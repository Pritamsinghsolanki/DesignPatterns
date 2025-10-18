package org.example.DesignPatterns.Visitor;

public class Main {
    public static void main(String[] args)
    {
        Animal monkey = new Monkey();
        Animal lion = new Lion();
        Animal dolphin = new Dolphin();

        AnimalVisitor speak = new Speak();

        monkey.accept(speak);
        lion.accept(speak);
        dolphin.accept(speak);

        AnimalVisitor jump = new Jump();

        monkey.accept(jump);
        lion.accept(jump);
        dolphin.accept(jump);

    }
}
