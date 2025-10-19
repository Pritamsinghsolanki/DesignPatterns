package org.example.Multithreading.Problems;
import java.util.concurrent.*;

public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Producer thread
        Runnable producer = () -> {
            int value = 0;
            try {
                while (true) {
                    System.out.println("Produced: " + value);
                    queue.put(value++);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        };

        // Consumer thread
        Runnable consumer = () -> {
            try {
                while (true) {
                    int val = queue.take();
                    System.out.println("Consumed: " + val);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}


//ArrayBlockingQueue is thread-safe and uses internal locks.
//
//put() blocks if queue is full.
//
//take() blocks if queue is empty.
//✅ No explicit synchronization required