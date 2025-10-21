package org.example.LLD.Problems.ElevatorSystem;

import org.example.LLD.Problems.ElevatorSystem.Controller.ElevatorSystemController;
import org.example.LLD.Problems.ElevatorSystem.Service.ElevatorController;

public class ElevatorSystemApp {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(3);
        ElevatorSystemController systemController = new ElevatorSystemController(controller);

        // Simulate requests
        systemController.requestElevator(0, 5);
        systemController.requestElevator(3, 9);
        systemController.requestElevator(2, 6);
    }
}

