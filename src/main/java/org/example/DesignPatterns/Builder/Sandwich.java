package org.example.DesignPatterns.Builder;

public class Sandwich {
    private int size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean lettuce;
    private boolean tomato;

    public Sandwich(SandwichBuilder builder){
        this.size = builder.getSize();
        this.cheese = builder.hasLettuce();
        this.lettuce = builder.hasLettuce();
        this.tomato = builder.hasTomato();
        this.pepperoni = builder.hasPepperoni();
    }

    public String getDescription()
    {
        return "This is a sandwitch of size"+ size + "containing: " + (cheese ? "cheese":"");
    }


}
