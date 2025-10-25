package org.example.LLD.Problems.VendingMachine;

import org.example.LLD.Problems.VendingMachine.Factory.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Integer, Item> items = new HashMap<>();

    public void addItem(Item item){ items.put(item.getId(), item);}

    public Item getItem(int id){ return items.get(id);}

    public void updateQuantity(int id,int qty){
        items.get(id).reduceQuantity(qty);
    }
}
