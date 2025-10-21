package org.example.LLD.Problems.ElevatorSystem.Request;

import org.example.LLD.Problems.ElevatorSystem.Entities.Direction;
import org.example.LLD.Problems.ElevatorSystem.Entities.ElevatorState;

public class ElevatorEvent {
    private final int elevatorId;
    private final int currentFloor;
    private final ElevatorState state;
    private final Direction direction;


    public ElevatorEvent(int elevatorId, int currentFloor, ElevatorState state, Direction direction) {
        this.elevatorId = elevatorId;
        this.currentFloor = currentFloor;
        this.state = state;
        this.direction = direction;
    }

    public int getElevatorId() { return elevatorId; }
    public int getCurrentFloor() { return currentFloor; }
    public ElevatorState getState() { return state; }
    public Direction getDirection() { return direction; }
}
