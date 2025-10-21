package org.example.LLD.Problems.ElevatorSystem;

import org.example.LLD.Problems.ElevatorSystem.Entities.Direction;
import org.example.LLD.Problems.ElevatorSystem.Entities.ElevatorState;
import org.example.LLD.Problems.ElevatorSystem.Interfaces.ElevatorObserver;
import org.example.LLD.Problems.ElevatorSystem.Request.ElevatorEvent;
import org.example.LLD.Problems.ElevatorSystem.Request.FloorRequest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorCar {
    private final int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private Queue<FloorRequest> requests;
    private final List<ElevatorObserver> observers = new ArrayList<>();


    public ElevatorCar(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;
        this.requests = new LinkedList<>();
    }

    // Observer registration
    public void addObserver(ElevatorObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ElevatorObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        ElevatorEvent event = new ElevatorEvent(id, currentFloor, state, direction);
        for (ElevatorObserver observer : observers) {
            observer.update(event);
        }
    }

    public synchronized void addRequest(FloorRequest request){
        requests.offer(request);
        notifyObservers();
    }

    public synchronized void move(){
        while(!requests.isEmpty())
        {
            FloorRequest request = requests.poll();
            moveToFloor(request.getSourceFloor());
            moveToFloor(request.getDestinationFloor());
        }
        direction = Direction.IDLE;
        state = ElevatorState.IDLE;
        notifyObservers();
    }

    private void moveToFloor(int targetFloor) {
        state = ElevatorState.MOVING;
        System.out.println("Elevator " + id + " moving from " + currentFloor + " to " + targetFloor);
        currentFloor = targetFloor;
        openDoor();
        closeDoor();
        notifyObservers();
    }

    private void openDoor() {
        state = ElevatorState.STOPPED;
        System.out.println("Elevator " + id + " Door opened.");
    }
    private void closeDoor() {
        state = ElevatorState.STOPPED;
        System.out.println("Elevator " + id + " Door closed.");
    }

    public int getCurrentFloor() { return currentFloor; }
    public Direction getDirection() { return direction; }
    public ElevatorState getState() { return state; }
    public int getId() { return id; }

}
