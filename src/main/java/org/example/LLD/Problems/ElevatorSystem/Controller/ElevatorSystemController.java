package org.example.LLD.Problems.ElevatorSystem.Controller;

import org.example.LLD.Problems.ElevatorSystem.Request.FloorRequest;
import org.example.LLD.Problems.ElevatorSystem.Service.ElevatorController;

public class ElevatorSystemController {
    private final ElevatorController elevatorController;

    public ElevatorSystemController(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    public void requestElevator(int source, int destination) {
        FloorRequest request = new FloorRequest(source, destination);
        elevatorController.handleRequest(request);
    }
}

