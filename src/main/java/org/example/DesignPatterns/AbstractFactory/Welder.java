package org.example.DesignPatterns.AbstractFactory;

public class Welder implements DoorFilteringExpert{
    @Override
    public void getDescription() {
        System.out.println("I;am a welder ,I install iron doors");
    }
}
