package org.example.DesignPatterns.Momento;

public class MomentoPatternDemo {
    public static void main(String[] args){
        TextEditor textEditor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        textEditor.type("Hello ");
        caretaker.addMomento(textEditor.save());

        textEditor.type("World");
        caretaker.addMomento(textEditor.save());

        textEditor.restore(caretaker.getMomento(0));
        System.out.println("First saved content"+ textEditor.getContent());


        textEditor.restore(caretaker.getMomento(1));
        System.out.println("First saved content"+ textEditor.getContent());

    }
}
