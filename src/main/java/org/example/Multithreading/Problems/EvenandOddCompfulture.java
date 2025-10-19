package org.example.Multithreading.Problems;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenandOddCompfulture {
    private static Object object = new Object();

    private static IntPredicate evenConditon = e -> e%2==0;
    private static IntPredicate oddConditon = e -> e%2!=0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()-> EvenandOddCompfulture.printResults(oddConditon));
        CompletableFuture.runAsync(()-> EvenandOddCompfulture.printResults(evenConditon));
        Thread.sleep(1000);

    }

    public static void printResults(IntPredicate condition){
        IntStream.rangeClosed(1,10)
                .filter(condition)
                .forEach(EvenandOddCompfulture::execute);
    }

    public static void execute(int i){
        synchronized (object){
            try {
                System.out.println("Thread name: " + Thread.currentThread().getName() + " : " + i);
                object.notify();
                object.wait();
            }catch (InterruptedException e){
                // error log
            }
        }
    }
}
