package org.example.LLD.Problems.VendingMachine.Factory;

public class Item {
    private int id;
    private String name;
    private int price;
    private int quantity;

    public Item(int id,String name,int price,int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isAvailable(){ return quantity > 0;}
    public void reduceQuantity(int qty) { quantity-=qty; }
    public int getPrice(){ return price;}
    public String getName(){ return name;}

    public int getId() {
        return id;
    }
}
