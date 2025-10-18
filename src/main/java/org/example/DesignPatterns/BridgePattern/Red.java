package org.example.DesignPatterns.BridgePattern;

public class Red implements Color{

    @Override
    public void fill() {
        System.out.println("Filling with red color.");
    }
}
