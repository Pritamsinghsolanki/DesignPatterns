package org.example.DesignPatterns.Facade;

public class SoundSystem {
    public void on(){
        System.out.println("Sound System in on");
    }
    public void off(){
        System.out.println("Sound System is off");
    }
    public void setVolume(int level){
        System.out.println("Sound system volume set to: "+ level);
    }
}
