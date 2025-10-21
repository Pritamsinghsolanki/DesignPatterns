package org.example.LLD.Problems.ElevatorSystem.Stratergy;

import org.example.LLD.Problems.ElevatorSystem.Interfaces.ElevatorObserver;
import org.example.LLD.Problems.ElevatorSystem.Request.ElevatorEvent;

public class MonitoringSystem implements ElevatorObserver {
    @Override
    public void update(ElevatorEvent event) {
        System.out.println("[Monitor] Elevator " + event.getElevatorId()
                + " changed state to " + event.getState() +
                " at floor " + event.getCurrentFloor());
    }
}
