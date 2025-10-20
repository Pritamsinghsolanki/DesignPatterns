package org.example.LLD.Problems.ParkingLot.Controllers;

import org.example.LLD.Problems.ParkingLot.Entites.Payment;
import org.example.LLD.Problems.ParkingLot.Services.ParkingService;
import org.example.LLD.Problems.ParkingLot.Services.PaymentStrategy.PaymentProcessor;

public class ExitGateController {
    private final ParkingService service = new ParkingService();

    public Payment vehicleExit(String ticketId, PaymentProcessor paymentProcessor){
        return service.unParkVehicle(ticketId, paymentProcessor);
    }
}
