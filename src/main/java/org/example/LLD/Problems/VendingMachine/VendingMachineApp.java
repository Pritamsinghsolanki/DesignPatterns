package org.example.LLD.Problems.VendingMachine;

import org.example.DesignPatterns.Strategy.PaymentStrategy;
import org.example.LLD.Problems.VendingMachine.Factory.ItemFactory;
import org.example.LLD.Problems.VendingMachine.Interface.Impl.DispenseCommand;
import org.example.LLD.Problems.VendingMachine.Interface.Impl.InsertCoinCommand;
import org.example.LLD.Problems.VendingMachine.Interface.Impl.RefundCommand;
import org.example.LLD.Problems.VendingMachine.Interface.Impl.SelectItemCommand;
import org.example.LLD.Problems.VendingMachine.Observer.InventoryAlertSystem;
import org.example.LLD.Problems.VendingMachine.Observer.TransactionLogger;
import org.example.LLD.Problems.VendingMachine.stratergy.CoinPaymentStrategy;

public class VendingMachineApp {

    public static void main(String[] args) {

        // STEP 1: Create Singleton instance
        VendingMachine machine = VendingMachine.getInstance();

        // STEP 2: Set Payment Strategy (Strategy Pattern)
        machine.setPaymentStrategy(new CoinPaymentStrategy());

        // STEP 3: Register Observers (Observer Pattern)
        machine.registerObserver(new TransactionLogger());
        machine.registerObserver(new InventoryAlertSystem());

        // STEP 4: Load items using Factory Pattern
        machine.getInventory().addItem(ItemFactory.createItem(1, "drink"));
        machine.getInventory().addItem(ItemFactory.createItem(2, "snack"));
        machine.getInventory().addItem(ItemFactory.createItem(3, "drink"));

        // STEP 5: Setup Command Console (Invoker)
        VendingMachineConsole console = new VendingMachineConsole();

        // Map buttons to actions (Command Pattern)
        console.setCommand("insert10", new InsertCoinCommand(machine, 10));
        console.setCommand("insert20", new InsertCoinCommand(machine, 20));
        console.setCommand("insert50", new InsertCoinCommand(machine, 50));

        console.setCommand("select1", new SelectItemCommand(machine, 1)); // Coke
        console.setCommand("select2", new SelectItemCommand(machine, 2)); // Chips
        console.setCommand("select3", new SelectItemCommand(machine, 3)); // Coke again

        console.setCommand("refund", new RefundCommand(machine));
        console.setCommand("dispense", new DispenseCommand(machine));

        // STEP 6: Simulate realistic user flow
        System.out.println("\n======= VENDING MACHINE SIMULATION START =======");

        // User inserts coins
        console.pressButton("insert10");
        console.pressButton("insert20");

        // User selects an item
        console.pressButton("select1");

        // Optional: user tries to select another item without inserting enough money
        console.pressButton("select2");

        // User inserts more coins
        console.pressButton("insert50");

        // Select again
        console.pressButton("select2");

        // Simulate refund (optional)
        console.pressButton("refund");

        System.out.println("======= VENDING MACHINE SIMULATION END =======");
    }
}
