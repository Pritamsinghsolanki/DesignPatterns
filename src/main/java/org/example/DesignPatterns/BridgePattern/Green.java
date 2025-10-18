package org.example.DesignPatterns.BridgePattern;

public class Green implements Color{

    @Override
    public void fill() {
        System.out.println("Filling with green color.");
    }
}
