package org.example.DesignPatterns.Visitor;

public class Dolphin implements Animal{

    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visitDolphin(this);
    }
}
