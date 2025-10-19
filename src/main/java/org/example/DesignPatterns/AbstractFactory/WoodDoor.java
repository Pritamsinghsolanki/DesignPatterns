package org.example.DesignPatterns.AbstractFactory;

public class WoodDoor implements Door{
    @Override
    public void getDescription() {
        System.out.println("I'm a wooden door");
    }
}
