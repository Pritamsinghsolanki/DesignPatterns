package org.example.LLD.Problems.VendingMachine.Interface.Impl;

import org.example.LLD.Problems.VendingMachine.Interface.VendingState;
import org.example.LLD.Problems.VendingMachine.VendingMachine;

public class IdleState implements VendingState {
    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        System.out.println("Money inserted: " + amount);
        machine.getPaymentStrategy().pay(amount);
        machine.setState(new HasMoneyState());
    }

    @Override
    public void selectItem(VendingMachine machine, int itemId) {
        System.out.println("Insert money first!");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Please insert money first.");
    }

    @Override
    public void refund(VendingMachine machine) {
        System.out.println("No transaction to refund.");
    }
}
