package org.example.DesignPatterns.Builder;

public class Main {
    public static void main(String[] args)
    {
        Sandwich sandwich = new SandwichBuilder()
                .setSize(14)
                .addCheese()
                .addTomato()
                .addPepperoni()
                .build();

                System.out.println(sandwich.getDescription());
    }
}
