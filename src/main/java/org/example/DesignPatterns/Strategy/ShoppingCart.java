package org.example.DesignPatterns.Strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart(){
        items = new ArrayList<>();
    }
    public void addItem(Item item){
        items.add(item);
    }
    public int calculateTotal(){
        int sum=0;
        for(Item item: items){
            sum+=item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentStrategy)
    {
        int amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
}
