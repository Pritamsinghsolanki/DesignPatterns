package org.example.LLD.Problems.ParkingLot.Entites;

import org.example.LLD.Problems.ParkingLot.Entites.Interfaces.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private final String id;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final ParkingFloor floor;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Payment payment;


    public Ticket(String id, Vehicle vehicle, ParkingSpot spot, ParkingFloor floor) {
        this.id = id;
        this.vehicle = vehicle;
        this.spot = spot;
        this.floor = floor;
        this.entryTime = LocalDateTime.now();
    }

    public void closeTicket(Payment payment){
        this.exitTime  = LocalDateTime.now();
        this.payment = payment;
    }

    public String getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getSpot() { return spot; }
    public ParkingFloor getFloor() { return floor; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public Payment getPayment() { return payment; }

}
