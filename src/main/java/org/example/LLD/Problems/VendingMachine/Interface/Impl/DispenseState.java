package org.example.LLD.Problems.VendingMachine.Interface.Impl;

import org.example.LLD.Problems.VendingMachine.Factory.Item;
import org.example.LLD.Problems.VendingMachine.Interface.VendingState;
import org.example.LLD.Problems.VendingMachine.VendingMachine;

public class DispenseState implements VendingState {
    private final Item item;

    public DispenseState(Item item) { this.item = item; }

    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        System.out.println("Dispensing in progress...");
    }

    @Override
    public void selectItem(VendingMachine machine, int itemId) {
        System.out.println("Already dispensing...");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Dispensing: " + item.getName());
        item.reduceQuantity(1);
        int remaining = machine.getPaymentStrategy().deduct(item.getPrice());
        if (remaining > 0) {
            System.out.println("Returning change: " + remaining);
        }

        machine.notifyObservers("Dispensed " + item.getName());
        machine.setState(new IdleState());
    }

    @Override
    public void refund(VendingMachine machine) {
        System.out.println("Cannot refund during dispensing.");
    }
}
