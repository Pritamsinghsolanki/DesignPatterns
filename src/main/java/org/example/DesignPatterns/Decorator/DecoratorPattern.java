package org.example.DesignPatterns.Decorator;

public class DecoratorPattern {
    public static void main(String[] args){
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription()+ "$"+ coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription()+ "$"+ coffee.getCost());


        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription()+ "$"+ coffee.getCost());

    }
}
