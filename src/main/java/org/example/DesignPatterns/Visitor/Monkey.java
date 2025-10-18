package org.example.DesignPatterns.Visitor;

public class Monkey implements Animal{

    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visitMonkey(this);
    }
}
