package org.example.LLD.Problems.ParkingLot.Services;

import org.example.LLD.Problems.ParkingLot.Entites.ParkingFloor;
import org.example.LLD.Problems.ParkingLot.Entites.Ticket;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// Singleton Pattern for ParkingLot
public class ParkingLot {
    private static ParkingLot instance;
    private final List<ParkingFloor> floors = new ArrayList<>();
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();

    private ParkingLot() {}

    public static synchronized ParkingLot getInstance() {
        if (instance == null) instance = new ParkingLot();
        return instance;
    }

    public void addFloor(ParkingFloor floor) { floors.add(floor); }
    public List<ParkingFloor> getFloors() { return floors; }

    public void registerTicket(Ticket ticket) { activeTickets.put(ticket.getId(), ticket); }
    public Ticket getTicket(String id) { return activeTickets.get(id); }
    public void removeTicket(String id) { activeTickets.remove(id); }
}

