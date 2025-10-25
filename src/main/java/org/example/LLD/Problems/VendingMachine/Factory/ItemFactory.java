package org.example.LLD.Problems.VendingMachine.Factory;

public class ItemFactory {
    public static Item createItem(int id, String type) {
        switch (type.toLowerCase()) {
            case "drink": return new Item(id, "Coke", 25, 5);
            case "snack": return new Item(id, "Chips", 15, 3);
            default: throw new IllegalArgumentException("Unknown item type");
        }
    }
}
