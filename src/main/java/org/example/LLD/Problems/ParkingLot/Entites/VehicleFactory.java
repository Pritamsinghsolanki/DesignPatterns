package org.example.LLD.Problems.ParkingLot.Entites;

import org.example.LLD.Problems.ParkingLot.Entites.Enums.VehicleType;
import org.example.LLD.Problems.ParkingLot.Entites.Interfaces.Vehicle;

public class VehicleFactory {
    public static Vehicle createFactory(VehicleType type, String licenseNumber){
        return switch(type) {
            case CAR -> new Car(licenseNumber);
            case BIKE -> new Bike(licenseNumber);
            case TRUCK -> new Truck(licenseNumber);
            default -> throw new IllegalArgumentException("Unsupported Vehicle Type");
        };
    }
}
