package org.example.LLD.Problems.VendingMachine.Interface.Impl;

import org.example.LLD.Problems.VendingMachine.Interface.Command;
import org.example.LLD.Problems.VendingMachine.VendingMachine;

public class SelectItemCommand implements Command {
    private final VendingMachine machine;
    private final int itemId;

    public SelectItemCommand(VendingMachine machine, int itemId) {
        this.machine = machine;
        this.itemId = itemId;
    }

    @Override
    public void execute() {
        System.out.println("[Command] Executing SelectItemCommand");
        machine.selectItem(itemId);
    }
}

