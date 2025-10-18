package org.example.DesignPatterns.Strategy;

public class Item {
    String key;
    int value;

    public Item(String key,int val)
    {
        this.key = key;
        this.value = val;
    }

    public int getPrice()
    {
        return value;
    }

}
