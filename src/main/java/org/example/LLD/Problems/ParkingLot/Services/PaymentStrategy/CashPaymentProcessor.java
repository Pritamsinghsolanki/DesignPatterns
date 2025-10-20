package org.example.LLD.Problems.ParkingLot.Services.PaymentStrategy;

import org.example.LLD.Problems.ParkingLot.Entites.Enums.PaymentMode;
import org.example.LLD.Problems.ParkingLot.Entites.Payment;

public class CashPaymentProcessor implements PaymentProcessor {
    public Payment processPayment(String ticketId, double amount) {
        Payment p = new Payment(ticketId, amount, PaymentMode.CASH);
        p.markSuccess();
        return p;
    }
}
