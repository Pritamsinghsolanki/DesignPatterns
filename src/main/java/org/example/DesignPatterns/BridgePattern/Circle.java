package org.example.DesignPatterns.BridgePattern;

public class Circle extends Shape{

    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
       System.out.println("Drawing Circle. ");
       color.fill();
    }
}
