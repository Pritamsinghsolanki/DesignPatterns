package org.example.LLD.Problems.VendingMachine.stratergy;

public class CoinPaymentStrategy implements PaymentStrategy {
    private int balance = 0;

    @Override
    public void pay(int amount) {
        balance += amount;
        System.out.println("Coin inserted: " + amount);
    }

    @Override
    public int getBalance() { return balance; }

    @Override
    public int deduct(int amount) {
        balance -= amount;
        return balance;
    }

    @Override
    public int refund() {
        int refund = balance;
        balance = 0;
        return refund;
    }
}

