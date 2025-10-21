package org.example.LLD.Problems.ElevatorSystem.Interfaces;

import org.example.LLD.Problems.ElevatorSystem.Request.ElevatorEvent;

public interface ElevatorObserver {
    void update(ElevatorEvent event);
}