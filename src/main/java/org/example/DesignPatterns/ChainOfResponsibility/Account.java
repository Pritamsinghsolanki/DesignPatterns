package org.example.DesignPatterns.ChainOfResponsibility;

abstract class Account {
    protected Account successor;
    protected double balance;

    public void setNext(Account account){
        this.successor = account;
    }

    public void pay(double amountToPay){
        if(canPay(amountToPay)){
            System.out.printf("Paid %s using %s%n", amountToPay, this.getClass().getSimpleName());
        }else if(successor != null){
            System.out.printf("Cannot pay using %s. Proceeding ... %n",this.getClass().getSimpleName());
            successor.pay(amountToPay);
        }else {
            throw new RuntimeException("None of the accounts have enough balance");
        }
    }

    public boolean canPay(double amount){
        return this.balance>=amount;
    }
}
