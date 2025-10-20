package org.example.LLD.Problems.ParkingLot.Entites;

import org.example.LLD.Problems.ParkingLot.Entites.Enums.VehicleType;
import org.example.LLD.Problems.ParkingLot.Entites.Interfaces.Vehicle;

public class Bike implements Vehicle {
    private final String licenseNumber;

    public Bike(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}
