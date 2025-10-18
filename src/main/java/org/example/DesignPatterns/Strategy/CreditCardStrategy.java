package org.example.DesignPatterns.Strategy;

public class CreditCardStrategy implements PaymentStrategy{

    private String CardNumber;

    public CreditCardStrategy(String cardNumber)
    {
       this.CardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid "+ amount + " using Credit Card.");
    }
}
