package org.example.DesignPatterns.Facade;

public class Main {
    public static void main(String[] args)
    {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        Screen screen = new Screen();

        HomeTheatorFacade homeTheatorFacade = new HomeTheatorFacade(dvdPlayer, projector, soundSystem, screen);

        homeTheatorFacade.watchMovie("Inception");
        homeTheatorFacade.endMovie();
    }
}
