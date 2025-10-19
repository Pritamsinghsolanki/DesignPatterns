package org.example.DesignPatterns.AbstractFactory;

public class Carpenter implements DoorFilteringExpert{
    @Override
    public void getDescription() {
        System.out.println("I'am a carpenter, I install wooden doors");
    }
}
