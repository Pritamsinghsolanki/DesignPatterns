package org.example.LLD.Problems.VendingMachine.Interface.Impl;

import org.example.LLD.Problems.VendingMachine.Interface.Command;
import org.example.LLD.Problems.VendingMachine.VendingMachine;

public class InsertCoinCommand implements Command {
    private final VendingMachine machine;
    private final int amount;

    public InsertCoinCommand(VendingMachine machine, int amount) {
        this.machine = machine;
        this.amount = amount;
    }

    @Override
    public void execute() {
        System.out.println("[Command] Executing InsertCoinCommand");
        machine.insertCoin(amount);
    }
}
