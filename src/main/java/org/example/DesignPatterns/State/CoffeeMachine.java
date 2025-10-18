package org.example.DesignPatterns.State;

public class CoffeeMachine {
    private CoffeeMachineState idleState;
    private CoffeeMachineState selectingState;
    private CoffeeMachineState dispensingState;

    private CoffeeMachineState currentState;

    public CoffeeMachine() {
        idleState = new IdleState(this);
        selectingState = new SelectingState(this);
        dispensingState = new DispensingState(this);

        currentState = idleState;// Initial state
    }

    public void setState(CoffeeMachineState state){
        currentState = state;
    }

    public CoffeeMachineState getIdleState(){
        return idleState;
    }

    public void insertCoin(){
        currentState.insertCoin();
    }

    public void selectCoffee(){
        currentState.selectCoffee();
    }

    public void dispenseCoffee(){
        currentState.dispenseCoffee();
    }


    public CoffeeMachineState getSelectingState() {
        return selectingState;
    }

    public CoffeeMachineState getDispensingState() {
        return dispensingState;
    }
}
