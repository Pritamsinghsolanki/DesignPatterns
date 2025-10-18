package org.example.DesignPatterns.Singleton;

public class Multithreaded {
    private static Multithreaded uniqueInstance;

    private Multithreaded(){};

    public static Multithreaded getInstance(){
        if(uniqueInstance==null){
            synchronized (Singleton.class) {
                if(uniqueInstance==null) uniqueInstance = new Multithreaded();
            }
        }
        return uniqueInstance;
    }

    public void showMessage(){
        System.out.println("Hello, I am a Singleton!");
    }
}
