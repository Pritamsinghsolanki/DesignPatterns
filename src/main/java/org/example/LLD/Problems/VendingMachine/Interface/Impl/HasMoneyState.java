package org.example.LLD.Problems.VendingMachine.Interface.Impl;

import org.example.LLD.Problems.VendingMachine.Interface.VendingState;
import org.example.LLD.Problems.VendingMachine.Factory.Item;
import org.example.LLD.Problems.VendingMachine.VendingMachine;

public class HasMoneyState implements VendingState {
    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        machine.getPaymentStrategy().pay(amount);
        System.out.println("Added more balance: " + amount);
    }

    @Override
    public void selectItem(VendingMachine machine, int itemId) {
        Item item = machine.getInventory().getItem(itemId);
        if (item == null || !item.isAvailable()) {
            System.out.println("Item unavailable. Refunding...");
            machine.setState(new RefundState());
            machine.refund();
            return;
        }

        if (machine.getPaymentStrategy().getBalance() >= item.getPrice()) {
            System.out.println("Item selected: " + item.getName());
            machine.setState(new DispenseState(item));
            machine.dispense();
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void refund(VendingMachine machine) {
        machine.setState(new RefundState());
        machine.refund();
    }
}
