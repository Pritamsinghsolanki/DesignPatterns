package org.example.LLD.Problems.ParkingLot;

import org.example.LLD.Problems.ParkingLot.Controllers.EntryGateController;
import org.example.LLD.Problems.ParkingLot.Controllers.ExitGateController;
import org.example.LLD.Problems.ParkingLot.Entites.Enums.VehicleType;
import org.example.LLD.Problems.ParkingLot.Entites.ParkingFloor;
import org.example.LLD.Problems.ParkingLot.Entites.ParkingSpot;
import org.example.LLD.Problems.ParkingLot.Entites.Payment;
import org.example.LLD.Problems.ParkingLot.Entites.Ticket;
import org.example.LLD.Problems.ParkingLot.Services.ParkingLot;
import org.example.LLD.Problems.ParkingLot.Services.PaymentStrategy.CardPaymentProcessor;
import org.example.LLD.Problems.ParkingLot.Services.PaymentStrategy.CashPaymentProcessor;

import java.util.List;

public class ParkingLotMain {
    public static void main(String[] args) throws InterruptedException {
        ParkingFloor floor1 = new ParkingFloor("F1",
                List.of(new ParkingSpot("S1", VehicleType.CAR),
                              new ParkingSpot("S2", VehicleType.CAR)));
        ParkingLot.getInstance().addFloor(floor1);

        EntryGateController entryGate = new EntryGateController();
        ExitGateController exitGate = new ExitGateController();

        //park vehicle
        Ticket t1 = entryGate.vehicleEntry("CAR-123",VehicleType.CAR);
        Ticket t2 = entryGate.vehicleEntry("CAR-456",VehicleType.CAR);


        //unpark vehicle
        Thread.sleep(1000);
        Payment payment1 = exitGate.vehicleExit(t1.getId(), new CashPaymentProcessor());
        Payment payment2 = exitGate.vehicleExit(t2.getId(), new CardPaymentProcessor());
    }
}
