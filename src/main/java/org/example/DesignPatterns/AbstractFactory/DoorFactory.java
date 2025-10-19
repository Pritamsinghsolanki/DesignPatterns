package org.example.DesignPatterns.AbstractFactory;

public interface DoorFactory {
    Door makeDoor();
    DoorFilteringExpert makeFilteringExpert();
}
