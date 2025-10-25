package org.example.LLD.Problems.VendingMachine;

import org.example.LLD.Problems.VendingMachine.Interface.Impl.IdleState;
import org.example.LLD.Problems.VendingMachine.Interface.Impl.RefundState;
import org.example.LLD.Problems.VendingMachine.stratergy.PaymentStrategy;
import org.example.LLD.Problems.VendingMachine.Interface.VendingState;
import org.example.LLD.Problems.VendingMachine.Observer.TransactionLogger;
import org.example.LLD.Problems.VendingMachine.Observer.VendingObserver;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private static VendingMachine instance;
    private VendingState state;
    private PaymentStrategy paymentStrategy;
    private final Inventory inventory;
    private final List<VendingObserver> observers = new ArrayList<>();

    private VendingMachine() {
        this.state = new IdleState();
        this.inventory = new Inventory();
    }

    public static synchronized VendingMachine getInstance() {
        if (instance == null) instance = new VendingMachine();
        return instance;
    }

    public void setState(VendingState state) { this.state = state; }
    public VendingState getState() { return state; }

    public Inventory getInventory() { return inventory; }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public PaymentStrategy getPaymentStrategy() { return paymentStrategy; }

    // Observer methods
    public void registerObserver(VendingObserver o) { observers.add(o); }
    public void notifyObservers(String message) {
        for (VendingObserver o : observers) o.update(message);
    }

    // API methods
    public void insertCoin(int amount) { state.insertCoin(this, amount); }
    public void selectItem(int itemId) { state.selectItem(this, itemId); }
    public void dispense() { state.dispense(this); }
    public void refund() { state.refund(this); }
}
