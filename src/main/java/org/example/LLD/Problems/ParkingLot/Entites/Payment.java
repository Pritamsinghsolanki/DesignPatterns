package org.example.LLD.Problems.ParkingLot.Entites;

import org.example.LLD.Problems.ParkingLot.Entites.Enums.PaymentMode;
import org.example.LLD.Problems.ParkingLot.Entites.Enums.PaymentStatus;

public class Payment {
    private final String id;
    private final double amount;
    private final PaymentMode mode;
    private PaymentStatus status;


    public Payment(String id, double amount, PaymentMode mode) {
        this.id = id;
        this.amount = amount;
        this.mode = mode;
    }

    public void markSuccess(){ this.status = PaymentStatus.SUCCESS;}
    public void markFailed(){ this.status = PaymentStatus.FAILED;}

    public PaymentStatus getStatus() { return status; }
    public double getAmount() { return amount; }
    public PaymentMode getMode() { return mode; }
}
