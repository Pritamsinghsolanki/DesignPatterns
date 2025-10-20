package org.example.LLD.Problems.ParkingLot.MultiFloor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

// Simulated Redis counters for available spots
class RedisCounter {
    private final ConcurrentMap<String, AtomicInteger> counters = new ConcurrentHashMap<>();

    public void setCounter(String key, int value) { counters.put(key, new AtomicInteger(value)); }
    public boolean decrement(String key) {
        AtomicInteger counter = counters.get(key);
        return counter != null && counter.getAndUpdate(val -> val > 0 ? val - 1 : val) > 0;
    }
    public void increment(String key) {
        AtomicInteger counter = counters.get(key);
        if (counter != null) counter.incrementAndGet();
    }
    public int get(String key) { return counters.getOrDefault(key, new AtomicInteger(0)).get(); }
}