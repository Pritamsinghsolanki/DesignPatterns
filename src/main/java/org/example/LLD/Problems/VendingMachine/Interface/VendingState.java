package org.example.LLD.Problems.VendingMachine.Interface;

import org.example.LLD.Problems.VendingMachine.Enums.Coin;
import org.example.LLD.Problems.VendingMachine.VendingMachine;

public interface VendingState {
    void insertCoin(VendingMachine machine, int amount);
    void selectItem(VendingMachine machine, int itemId);
    void dispense(VendingMachine machine);
    void refund(VendingMachine machine);
}
