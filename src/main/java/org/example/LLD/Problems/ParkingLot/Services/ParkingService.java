package org.example.LLD.Problems.ParkingLot.Services;

import org.example.LLD.Problems.ParkingLot.Entites.Interfaces.Vehicle;
import org.example.LLD.Problems.ParkingLot.Entites.ParkingFloor;
import org.example.LLD.Problems.ParkingLot.Entites.ParkingSpot;
import org.example.LLD.Problems.ParkingLot.Entites.Payment;
import org.example.LLD.Problems.ParkingLot.Entites.Ticket;
import org.example.LLD.Problems.ParkingLot.Services.PaymentStrategy.PaymentProcessor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class ParkingService {

    private final ParkingLot lot = ParkingLot.getInstance();

    public synchronized Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot assignedSpot = null;
        ParkingFloor assignedFloor = null;

        for (ParkingFloor floor : lot.getFloors()) {
            Optional<ParkingSpot> spot = floor.assignSpot(vehicle.getType());
            if (spot.isPresent()) {
                assignedSpot = spot.get();
                assignedFloor = floor;
                break;
            }
        }
        if (assignedSpot == null) throw new RuntimeException("No spot available");

        // Generate Ticket
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, assignedSpot, assignedFloor);
        lot.registerTicket(ticket);

        System.out.println("Ticket Generated: " + ticket.getId() + " for vehicle " + vehicle.getLicenseNumber());
        return ticket;
    }

    public synchronized Payment unParkVehicle(String ticketId, PaymentProcessor processor) {
        Ticket ticket = lot.getTicket(ticketId);
        if (ticket == null) throw new RuntimeException("Invalid ticket");

        // Calculate duration
        Duration duration = Duration.between(ticket.getEntryTime(), LocalDateTime.now());
        double fee = calculateFee(duration);

        // Process Payment
        Payment payment = processor.processPayment(ticketId, fee);
        ticket.closeTicket(payment);

        // Release Spot
        ticket.getFloor().releaseSpot(ticket.getSpot().getId());
        lot.removeTicket(ticketId);

        System.out.println("Vehicle " + ticket.getVehicle().getLicenseNumber() + " exited, fee: " + fee);
        return payment;
    }

    private double calculateFee(Duration duration) {
        long hours = duration.toHours() + 1; // charge rounding up
        return hours * 10; // 10/unit per hour
    }
}

