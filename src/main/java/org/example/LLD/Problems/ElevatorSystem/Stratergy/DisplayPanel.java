package org.example.LLD.Problems.ElevatorSystem.Stratergy;

import org.example.LLD.Problems.ElevatorSystem.Interfaces.ElevatorObserver;
import org.example.LLD.Problems.ElevatorSystem.Request.ElevatorEvent;

public class DisplayPanel implements ElevatorObserver {
    @Override
    public void update(ElevatorEvent event) {
        System.out.println("[Display] Elevator " + event.getElevatorId()
                + " | Floor: " + event.getCurrentFloor()
                + " | State: " + event.getState()
                + " | Direction: " + event.getDirection());
    }
}
