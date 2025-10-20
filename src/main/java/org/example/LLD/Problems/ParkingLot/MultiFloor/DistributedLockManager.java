package org.example.LLD.Problems.ParkingLot.MultiFloor;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

// Simulated distributed lock
class DistributedLockManager {
    private final ConcurrentMap<String, ReentrantLock> locks = new ConcurrentHashMap<>();

    public ReentrantLock acquireLock(String key) {
        locks.putIfAbsent(key, new ReentrantLock());
        ReentrantLock lock = locks.get(key);
        lock.lock();
        return lock;
    }

    public void releaseLock(String key) {
        ReentrantLock lock = locks.get(key);
        if (lock != null && lock.isHeldByCurrentThread()) lock.unlock();
    }
}