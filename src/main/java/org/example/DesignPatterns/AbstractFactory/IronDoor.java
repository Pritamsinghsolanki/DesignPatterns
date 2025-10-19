package org.example.DesignPatterns.AbstractFactory;

//concrete product
public class IronDoor implements Door{
    @Override
    public void getDescription() {
        System.out.println("I'm an iron door");
    }
}
