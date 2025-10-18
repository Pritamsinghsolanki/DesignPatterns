package org.example.DesignPatterns.BridgePattern;

public class BridgePattern {
    public static void main(String[] args){
        Shape redCircle = new Circle(new Red());
        Shape greenSquare = new Square(new Green());
        redCircle.draw();
        greenSquare.draw();
    }
}
