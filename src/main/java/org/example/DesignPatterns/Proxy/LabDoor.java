package org.example.DesignPatterns.Proxy;

public class LabDoor implements Door{

    @Override
    public void open(String param) {
        System.out.println("Opening lab door");
    }

    @Override
    public void close() {
        System.out.println("Closing the lab door");
    }
}
