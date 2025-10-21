package org.example.LLD.Problems.ElevatorSystem.Request;

import org.example.LLD.Problems.ElevatorSystem.Entities.Direction;

public class FloorRequest {
    private int sourceFloor;
    private int destinationFloor;
    private Direction direction;

    public FloorRequest(int sourceFloor, int destinationFloor){
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
        this.direction = direction;
    }

    public int getSourceFloor(){ return sourceFloor;}
    public int getDestinationFloor(){ return destinationFloor;}
    public Direction getDirection(){ return direction;}
}
