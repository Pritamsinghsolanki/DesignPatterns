package org.example.LLD.Problems.ParkingLot.Entites;

import org.example.LLD.Problems.ParkingLot.Entites.Enums.VehicleType;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingFloor {
    private final String floorId;
    private final Map<String, ParkingSpot> spots = new HashMap<>();
    private final Map<VehicleType, AtomicInteger> availableCount = new EnumMap<>(VehicleType.class);

    public ParkingFloor(String floorId, List<ParkingSpot> spotsList) {
        this.floorId = floorId;
        for (VehicleType vt : VehicleType.values()) availableCount.put(vt, new AtomicInteger(0));
        for (ParkingSpot s : spotsList) {
            spots.put(s.getId(), s);
            if (s.isAvailable()) availableCount.get(s.getSpotType()).incrementAndGet();
        }
    }

    public Optional<ParkingSpot> assignSpot(VehicleType type) {
        if (availableCount.get(type).get() <= 0) return Optional.empty();
        for (ParkingSpot spot : spots.values()) {
            if (spot.getSpotType() == type && spot.assignVehicle()) {
                availableCount.get(type).decrementAndGet();
                return Optional.of(spot);
            }
        }
        return Optional.empty();
    }

    public void releaseSpot(String spotId) {
        ParkingSpot spot = spots.get(spotId);
        if (spot != null && !spot.isAvailable()) {
            spot.releaseVehicle();
            availableCount.get(spot.getSpotType()).incrementAndGet();
        }
    }

    public int getAvailableCount(VehicleType type) { return availableCount.get(type).get(); }
    public String getFloorId() { return floorId; }
}
