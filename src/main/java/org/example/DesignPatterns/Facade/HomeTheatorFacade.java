package org.example.DesignPatterns.Facade;

public class HomeTheatorFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;
    private Screen screen;

    public HomeTheatorFacade(DVDPlayer dvdPlayer, Projector projector, SoundSystem soundSystem, Screen screen){
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.screen = screen;
    }

    public void watchMovie(String movie){
        System.out.println("Get ready to watch a movie...");
        screen.down();
        projector.on();
        projector.setInput("DVD");
        soundSystem.on();
        soundSystem.setVolume(10);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie(){
        System.out.println("Shutting movie theater down... ");
        dvdPlayer.off();
        soundSystem.off();
        projector.off();
        screen.up();
    }
}
