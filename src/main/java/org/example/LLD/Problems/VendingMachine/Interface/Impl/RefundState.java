package org.example.LLD.Problems.VendingMachine.Interface.Impl;


import org.example.LLD.Problems.VendingMachine.Interface.VendingState;
import org.example.LLD.Problems.VendingMachine.VendingMachine;

public class RefundState implements VendingState {
    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        System.out.println("Refund in progress. Please wait.");
    }

    @Override
    public void selectItem(VendingMachine machine, int itemId) {
        System.out.println("Refunding, cannot select now.");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Refund in progress...");
    }

    @Override
    public void refund(VendingMachine machine) {
        int refund = machine.getPaymentStrategy().refund();
        System.out.println("Refunded amount: " + refund);
        machine.notifyObservers("Refund of " + refund + " issued");
        machine.setState(new IdleState());
    }
}
