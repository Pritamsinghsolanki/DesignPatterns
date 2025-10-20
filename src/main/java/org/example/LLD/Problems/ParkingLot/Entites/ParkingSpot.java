package org.example.LLD.Problems.ParkingLot.Entites;

import org.example.LLD.Problems.ParkingLot.Entites.Enums.VehicleType;

public class ParkingSpot {
    private final String id;
    private final VehicleType spotType;
    private volatile boolean available = true;


    public ParkingSpot(String id, VehicleType spotType) {
        this.id = id;
        this.spotType = spotType;
    }

    public synchronized boolean assignVehicle(){
        if(available){
            available = false;
            return true;
        }
        return false;
    }

    public synchronized void releaseVehicle(){
        available = true;
    }

    public boolean isAvailable(){ return available;}
    public String getId(){ return id;}
    public VehicleType getSpotType() { return spotType;}
}
