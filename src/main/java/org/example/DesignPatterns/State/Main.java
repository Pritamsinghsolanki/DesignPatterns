package org.example.DesignPatterns.State;

public class Main {
    public static void main(String[] args)
    {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.insertCoin();
        coffeeMachine.selectCoffee();
        coffeeMachine.dispenseCoffee();
    }
}
