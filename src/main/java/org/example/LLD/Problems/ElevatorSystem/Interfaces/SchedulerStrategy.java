package org.example.LLD.Problems.ElevatorSystem.Interfaces;

import org.example.LLD.Problems.ElevatorSystem.ElevatorCar;
import org.example.LLD.Problems.ElevatorSystem.Request.FloorRequest;

import java.util.List;

public interface SchedulerStrategy {
    ElevatorCar assignElevator(List<ElevatorCar> elevatorCars, FloorRequest floorRequest);
}
