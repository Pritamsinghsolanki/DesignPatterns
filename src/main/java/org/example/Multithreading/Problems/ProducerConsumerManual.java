package org.example.Multithreading.Problems;

import java.util.LinkedList;

public class ProducerConsumerManual {
    private final LinkedList<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 5;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (queue.size() == CAPACITY)
                    wait(); // wait until consumer consumes

                System.out.println("Produced: " + value);
                queue.add(value++);
                notifyAll(); // notify consumers
            }
            Thread.sleep(500);
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.isEmpty())
                    wait(); // wait until producer produces

                int val = queue.removeFirst();
                System.out.println("Consumed: " + val);
                notifyAll(); // notify producer
            }
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerManual pc = new ProducerConsumerManual();
        new Thread(() -> {
            try { pc.produce(); } catch (InterruptedException e) {}
        }).start();

        new Thread(() -> {
            try { pc.consume(); } catch (InterruptedException e) {}
        }).start();
    }
}

