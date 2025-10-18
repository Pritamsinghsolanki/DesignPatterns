package org.example.DesignPatterns.Command;

//Invoker
public class RemoteControl {
    public void submit(Command  command){
        command.execute();
    }
}
