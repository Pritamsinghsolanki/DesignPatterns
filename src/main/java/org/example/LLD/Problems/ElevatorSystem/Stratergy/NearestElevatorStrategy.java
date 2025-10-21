package org.example.LLD.Problems.ElevatorSystem.Stratergy;

import org.example.LLD.Problems.ElevatorSystem.ElevatorCar;
import org.example.LLD.Problems.ElevatorSystem.Entities.ElevatorState;
import org.example.LLD.Problems.ElevatorSystem.Interfaces.SchedulerStrategy;
import org.example.LLD.Problems.ElevatorSystem.Request.FloorRequest;

import java.util.List;

public class NearestElevatorStrategy implements SchedulerStrategy {
    @Override
    public ElevatorCar assignElevator(List<ElevatorCar> elevatorCars, FloorRequest floorRequest) {
        ElevatorCar nearest = null;
        int minDistance = Integer.MAX_VALUE;
        for(ElevatorCar elevator: elevatorCars){
            int distance = Math.abs(elevator.getCurrentFloor() - floorRequest.getSourceFloor());
            if(distance < minDistance && elevator.getState() == ElevatorState.IDLE){
                nearest = elevator;
                minDistance = distance;
            }
        }
        return  nearest != null ? nearest : elevatorCars.get(0);
    }
}
