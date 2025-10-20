package org.example.LLD.Problems.ParkingLot.Controllers;

import org.example.LLD.Problems.ParkingLot.Entites.Enums.VehicleType;
import org.example.LLD.Problems.ParkingLot.Entites.Interfaces.Vehicle;
import org.example.LLD.Problems.ParkingLot.Entites.Ticket;
import org.example.LLD.Problems.ParkingLot.Entites.VehicleFactory;
import org.example.LLD.Problems.ParkingLot.Services.ParkingService;

public class EntryGateController {
    private final ParkingService service = new ParkingService();

    public Ticket vehicleEntry(String licenseNumber, VehicleType type){
        Vehicle v = VehicleFactory.createFactory(type, licenseNumber);
        return service.parkVehicle(v);
    }
}
