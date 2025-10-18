package org.example.DesignPatterns.Mediator;

public class UserImpl extends User{
    public UserImpl(ChatMediator med, String name){
        super(med,name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name+ " sends message: "+ message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name+ " receives message "+ message);
    }
}
