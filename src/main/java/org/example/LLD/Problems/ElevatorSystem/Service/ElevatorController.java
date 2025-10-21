package org.example.LLD.Problems.ElevatorSystem.Service;

import org.example.LLD.Problems.ElevatorSystem.ElevatorCar;
import org.example.LLD.Problems.ElevatorSystem.Interfaces.SchedulerStrategy;
import org.example.LLD.Problems.ElevatorSystem.Request.FloorRequest;
import org.example.LLD.Problems.ElevatorSystem.Stratergy.DisplayPanel;
import org.example.LLD.Problems.ElevatorSystem.Stratergy.MonitoringSystem;
import org.example.LLD.Problems.ElevatorSystem.Stratergy.NearestElevatorStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private final List<ElevatorCar> elevators;
    private final SchedulerStrategy scheduler;

    public ElevatorController(int numberOfElevators) {
        this.elevators = new ArrayList<>();
        for (int i = 1; i <= numberOfElevators; i++) {
            //observers
            ElevatorCar elevator = new ElevatorCar(i);
            elevator.addObserver(new DisplayPanel());
            elevator.addObserver(new MonitoringSystem());
            elevators.add(elevator);
        }
        this.scheduler = new NearestElevatorStrategy();
    }

    public void handleRequest(FloorRequest request) {
        ElevatorCar assignedElevator = scheduler.assignElevator(elevators, request);
        System.out.println("Assigned Elevator: " + assignedElevator.getId());
        assignedElevator.addRequest(request);

        // Move elevator in a separate thread for concurrency
        new Thread(assignedElevator::move).start();
    }

    public List<ElevatorCar> getElevators() {
        return elevators;
    }
}