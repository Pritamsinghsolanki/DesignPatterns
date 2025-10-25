package org.example.LLD.Problems.VendingMachine.stratergy;

public interface PaymentStrategy {
    void pay(int amount);
    int getBalance();
    int deduct(int amount);
    int refund();
}
