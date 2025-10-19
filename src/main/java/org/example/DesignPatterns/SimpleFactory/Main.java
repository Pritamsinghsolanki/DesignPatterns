package org.example.DesignPatterns.SimpleFactory;

public class Main {
    public static void main(String[] args)
    {
        HiringManager devManager= new DevelopmentManager();
        devManager.makeInterviewer();

        HiringManager marketingManager= new MarketingManager();
        marketingManager.makeInterviewer();
    }
}
