package org.example.LLD.Problems.VendingMachine.Observer;

public class InventoryAlertSystem implements VendingObserver {
    @Override
    public void update(String message) {
        System.out.println("[ALERT]: " + message);
    }
}

