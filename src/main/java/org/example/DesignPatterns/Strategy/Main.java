package org.example.DesignPatterns.Strategy;

public class Main {
    public static void main(String[] args)
    {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234", 10);
        Item item2 = new Item("5678", 40);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new CreditCardStrategy("1234-5678-1233-1212"));

        cart.pay(new PaypalStrategy("1234-5678-1233-1212"));

        cart.pay(new CreditCardStrategy("1234-5678-1233-1212"));
    }
}
