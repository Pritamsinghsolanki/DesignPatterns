package org.example.DesignPatterns.Visitor;

interface Animal {
    void accept(AnimalVisitor visitor);
}
