package org.example.LLD.Problems.VendingMachine.Service;

import org.example.LLD.Problems.VendingMachine.Enums.Coin;

public class PaymentService {
    private int currentBalance = 0;

    public void insertCoin(Coin coin){
        currentBalance+=coin.getValue();
        System.out.println("Inserted: "+ coin.getValue());
    }

    public boolean hasSufficientBalance(int price){
        return currentBalance >= price;
    }

    public int deductAmount(int price){
        currentBalance-=price;
        return currentBalance;
    }

    public int refund(){
        int refund = currentBalance;
        currentBalance = 0;
        return refund;
    }

    public int getCurrentBalance(){ return currentBalance;}
}
