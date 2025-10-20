package org.example.LLD.Problems.ParkingLot.Services.PaymentStrategy;

import org.example.LLD.Problems.ParkingLot.Entites.Enums.PaymentMode;
import org.example.LLD.Problems.ParkingLot.Entites.Payment;

public class CardPaymentProcessor implements PaymentProcessor {
    public Payment processPayment(String ticketId, double amount) {
        Payment p = new Payment(ticketId, amount, PaymentMode.CARD);
        p.markSuccess();
        return p;
    }
}
