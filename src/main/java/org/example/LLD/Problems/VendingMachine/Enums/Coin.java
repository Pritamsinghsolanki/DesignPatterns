package org.example.LLD.Problems.VendingMachine.Enums;

public enum Coin {
    ONE(1),TW0(2),FIVE(5),TEN(10);
    private int value;
    Coin(int value){ this.value = value;}
    public int getValue(){ return value;}
}