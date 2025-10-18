package org.example.DesignPatterns.Template;

class Tea extends CaffeineBeverage {
    void brew(){
        System.out.println("Stopping the tea");
    }

    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}