package org.example.DesignPatterns.Visitor;

public class Speak implements AnimalVisitor{

    @Override
    public void visitMonkey(Monkey monkey) {
        System.out.println("Monkey shout: Ooh oo aa aa!");
    }

    @Override
    public void visitLion(Lion lion) {
        System.out.println("Lion roar: Roaaar!");
    }

    @Override
    public void visitDolphin(Dolphin dolphin) {
        System.out.println("Dolphin speak: Tuut tutt tuut!");
    }
}
