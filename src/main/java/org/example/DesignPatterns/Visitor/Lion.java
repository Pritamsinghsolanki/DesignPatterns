package org.example.DesignPatterns.Visitor;

public class Lion implements Animal{

    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visitLion(this);
    }
}
