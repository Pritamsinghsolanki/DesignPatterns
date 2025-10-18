package org.example.DesignPatterns.Strategy;

public class PaypalStrategy implements PaymentStrategy{
    private String email;

    public PaypalStrategy(String email){
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid "+ amount + " using Paypal.");
    }
}
