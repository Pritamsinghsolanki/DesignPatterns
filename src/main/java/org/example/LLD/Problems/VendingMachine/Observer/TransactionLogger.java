package org.example.LLD.Problems.VendingMachine.Observer;

public class TransactionLogger implements VendingObserver {
    @Override
    public void update(String message) {
        System.out.println("[LOG]: " + message);
    }
}
