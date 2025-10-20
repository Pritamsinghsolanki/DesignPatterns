package org.example.LLD.Problems.ParkingLot.MultiFloor;

import org.example.LLD.Problems.ParkingLot.Entites.Enums.VehicleType;
import org.example.LLD.Problems.ParkingLot.Entites.Interfaces.Vehicle;
import org.example.LLD.Problems.ParkingLot.Entites.ParkingFloor;
import org.example.LLD.Problems.ParkingLot.Entites.ParkingSpot;
import org.example.LLD.Problems.ParkingLot.Entites.Payment;
import org.example.LLD.Problems.ParkingLot.Entites.Ticket;
import org.example.LLD.Problems.ParkingLot.Services.ParkingLot;
import org.example.LLD.Problems.ParkingLot.Services.PaymentStrategy.PaymentProcessor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

class MultiFloorParkingService {
    private final List<ParkingFloor> floors;
    private final DistributedLockManager lockManager;
    private final RedisCounter redisCounter;
    private final ParkingLot lot = ParkingLot.getInstance();

    public MultiFloorParkingService(List<ParkingFloor> floors,
                                    DistributedLockManager lockManager,
                                    RedisCounter redisCounter) {
        this.floors = floors;
        this.lockManager = lockManager;
        this.redisCounter = redisCounter;

        // Initialize Redis counters
        for (ParkingFloor floor : floors) {
            for (VehicleType vt : VehicleType.values()) {
                String key = counterKey(floor.getFloorId(), vt);
                redisCounter.setCounter(key, floor.getAvailableCount(vt));
            }
        }
    }

    private String counterKey(String floorId, VehicleType vt) { return floorId + ":" + vt; }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot assignedSpot = null;
        ParkingFloor assignedFloor = null;

        for (ParkingFloor floor : floors) {
            String counterKey = counterKey(floor.getFloorId(), vehicle.getType());
            if (redisCounter.get(counterKey) <= 0) continue; // skip full floor

            // Acquire lock per floor
            ReentrantLock lock = lockManager.acquireLock(floor.getFloorId() + ":" + vehicle.getType());
            try {
                Optional<ParkingSpot> spotOpt = floor.assignSpot(vehicle.getType());
                if (spotOpt.isPresent()) {
                    assignedSpot = spotOpt.get();
                    assignedFloor = floor;
                    redisCounter.decrement(counterKey);
                    break;
                }
            } finally {
                lockManager.releaseLock(floor.getFloorId() + ":" + vehicle.getType());
            }
        }

        if (assignedSpot == null) throw new RuntimeException("No spots available");

        // Generate ticket
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, assignedSpot, assignedFloor);
        lot.registerTicket(ticket);
        System.out.println("Ticket Generated: " + ticket.getId() + " for " + vehicle.getLicenseNumber());
        return ticket;
    }

    public Payment unParkVehicle(String ticketId, PaymentProcessor processor) {
        Ticket ticket = lot.getTicket(ticketId);
        if (ticket == null) throw new RuntimeException("Invalid ticket");

        ParkingFloor floor = ticket.getFloor();
        VehicleType type = ticket.getVehicle().getType();
        String counterKey = counterKey(floor.getFloorId(), type);

        // Lock spot/floor for concurrency
        ReentrantLock lock = lockManager.acquireLock(floor.getFloorId() + ":" + type);
        try {
            // Calculate fee
            Duration duration = Duration.between(ticket.getEntryTime(), LocalDateTime.now());
            double fee = duration.toHours() + 1 * 10; // simple per-hour fee

            // Payment processing
            Payment payment = processor.processPayment(ticketId, fee);
            ticket.closeTicket(payment);

            // Release spot
            floor.releaseSpot(ticket.getSpot().getId());
            redisCounter.increment(counterKey);

            lot.removeTicket(ticketId);
            System.out.println("Vehicle " + ticket.getVehicle().getLicenseNumber() + " exited. Fee: " + fee);
            return payment;
        } finally {
            lockManager.releaseLock(floor.getFloorId() + ":" + type);
        }
    }
}

