package org.example.DesignPatterns.Visitor;

interface AnimalVisitor {
    void visitMonkey(Monkey monkey);
    void visitLion(Lion lion);
    void visitDolphin(Dolphin dolphin);
}
