package org.example.DesignPatterns.AbstractFactory;

public class WoodenDoorFactory implements DoorFactory{

    @Override
    public Door makeDoor() {
        return new WoodDoor();
    }

    @Override
    public DoorFilteringExpert makeFilteringExpert() {
        return new Carpenter();
    }
}
