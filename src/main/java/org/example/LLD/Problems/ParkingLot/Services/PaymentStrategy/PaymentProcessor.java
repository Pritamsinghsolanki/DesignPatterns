package org.example.LLD.Problems.ParkingLot.Services.PaymentStrategy;

import org.example.LLD.Problems.ParkingLot.Entites.Payment;

public interface PaymentProcessor {
    Payment processPayment(String ticketId, double amount);
}
