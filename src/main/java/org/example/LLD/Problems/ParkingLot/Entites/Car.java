package org.example.LLD.Problems.ParkingLot.Entites;

import org.example.LLD.Problems.ParkingLot.Entites.Enums.VehicleType;
import org.example.LLD.Problems.ParkingLot.Entites.Interfaces.Vehicle;

public class Car implements Vehicle {
    String licenseNumber;

    public Car(String licenseNumber){
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
