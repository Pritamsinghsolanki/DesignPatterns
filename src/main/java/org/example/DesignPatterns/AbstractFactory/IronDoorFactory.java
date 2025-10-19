package org.example.DesignPatterns.AbstractFactory;

public class IronDoorFactory implements DoorFactory{
    @Override
    public Door makeDoor() {
        return new IronDoor();
    }

    @Override
    public DoorFilteringExpert makeFilteringExpert() {
        return new Welder();
    }
}
