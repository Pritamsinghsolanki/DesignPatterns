package org.example.DesignPatterns.Builder;

public class SandwichBuilder {
    private int size;
    private boolean cheese = false;
    private boolean lettuce = false;
    private boolean pepperoni = false;
    private boolean tomato = false;

    public SandwichBuilder setSize(int size){
        this.size = size;
        return this;
    }
    public SandwichBuilder addCheese(){
        this.cheese = true;
        return this;
    }
    public SandwichBuilder addLettuce(){
        this.lettuce = true;
        return this;
    }
    public SandwichBuilder addPepperoni(){
        this.pepperoni = true;
        return this;
    }
    public SandwichBuilder addTomato(){
        this.tomato = true;
        return this;
    }

    public boolean hasPepperoni(){
        return pepperoni;
    }

    public boolean hasLettuce(){
        return lettuce;
    }

    public boolean hasTomato(){
        return tomato;
    }

    public boolean hasCheese(){
        return cheese;
    }

    public int getSize(){
        return size;
    }

    public Sandwich build(){
        return new Sandwich(this);
    }
}
