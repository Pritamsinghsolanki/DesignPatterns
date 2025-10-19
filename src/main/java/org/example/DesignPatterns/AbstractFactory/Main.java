package org.example.DesignPatterns.AbstractFactory;

public class Main {
    public static void main(String[] args)
    {
        DoorFactory woodenFactory = new WoodenDoorFactory();
        Door woodenDoor = woodenFactory.makeDoor();
        DoorFilteringExpert woodenExpert = woodenFactory.makeFilteringExpert();

        woodenDoor.getDescription();
        woodenExpert.getDescription();


        DoorFactory ironFactory = new WoodenDoorFactory();
        Door ironDoor = woodenFactory.makeDoor();
        DoorFilteringExpert ironExpert = ironFactory.makeFilteringExpert();

        ironDoor.getDescription();
        ironExpert.getDescription();


    }
}
