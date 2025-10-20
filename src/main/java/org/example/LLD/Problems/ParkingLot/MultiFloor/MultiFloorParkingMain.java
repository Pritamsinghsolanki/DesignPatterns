package org.example.LLD.Problems.ParkingLot.MultiFloor;
import org.example.LLD.Problems.ParkingLot.Entites.Enums.VehicleType;
import org.example.LLD.Problems.ParkingLot.Entites.Interfaces.Vehicle;
import org.example.LLD.Problems.ParkingLot.Entites.ParkingFloor;
import org.example.LLD.Problems.ParkingLot.Entites.ParkingSpot;
import org.example.LLD.Problems.ParkingLot.Entites.Ticket;
import org.example.LLD.Problems.ParkingLot.Entites.VehicleFactory;
import org.example.LLD.Problems.ParkingLot.Services.PaymentStrategy.CashPaymentProcessor;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiFloorParkingMain {
    public static void main(String[] args) throws InterruptedException {
        MultiFloorParkingService service = getMultiFloorParkingService();

        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Ticket> tickets = Collections.synchronizedList(new ArrayList<>());

        // Simulate 4 cars trying to park concurrently
        for (int i = 0; i < 4; i++) {
            int id = i;
            pool.submit(() -> {
                try {
                    Vehicle v = VehicleFactory.createFactory(VehicleType.CAR, "CAR-" + id);
                    Ticket t = service.parkVehicle(v);
                    tickets.add(t);
                } catch (RuntimeException e) {
                    System.out.println("Parking failed for CAR-" + id + ": " + e.getMessage());
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        // Exit all parked cars
        for (Ticket t : tickets) {
            service.unParkVehicle(t.getId(), new CashPaymentProcessor());
        }
    }

    private static MultiFloorParkingService getMultiFloorParkingService() {
        ParkingFloor f1 = new ParkingFloor("F1", Arrays.asList(
                new ParkingSpot("F1-S1", VehicleType.CAR),
                new ParkingSpot("F1-S2", VehicleType.CAR)
        ));
        ParkingFloor f2 = new ParkingFloor("F2", Arrays.asList(
                new ParkingSpot("F2-S1", VehicleType.CAR)
        ));

        DistributedLockManager lockManager = new DistributedLockManager();
        RedisCounter redisCounter = new RedisCounter();

        MultiFloorParkingService service = new MultiFloorParkingService(
                Arrays.asList(f1, f2), lockManager, redisCounter
        );
        return service;
    }
}

