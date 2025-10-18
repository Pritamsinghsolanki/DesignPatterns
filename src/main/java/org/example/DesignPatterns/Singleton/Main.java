package org.example.DesignPatterns.Singleton;

public class Main {
    public static void main(String[] args)
    {
        Singleton instance = Singleton.getInstance();
        instance.showMessage();
    }
}
