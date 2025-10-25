package org.example.LLD.Problems.VendingMachine.Interface.Impl;

import org.example.LLD.Problems.VendingMachine.Interface.Command;
import org.example.LLD.Problems.VendingMachine.VendingMachine;

public class DispenseCommand implements Command {
    private final VendingMachine machine;

    public DispenseCommand(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        System.out.println("[Command] Executing DispenseCommand");
        machine.dispense();
    }
}

