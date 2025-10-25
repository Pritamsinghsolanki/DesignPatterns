package org.example.LLD.Problems.VendingMachine;

import org.example.LLD.Problems.VendingMachine.Interface.Command;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineConsole {
    private final Map<String, Command> buttonMap = new HashMap<>();

    public void setCommand(String button, Command command) {
        buttonMap.put(button, command);
    }

    public void pressButton(String button) {
        System.out.println("[Console] Button pressed: " + button);
        Command command = buttonMap.get(button);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command assigned to this button.");
        }
    }
}

