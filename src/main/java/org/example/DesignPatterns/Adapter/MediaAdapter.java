package org.example.DesignPatterns.Adapter;

public class MediaAdapter implements MediaPlayer{

    AdvancedMediaPlayer vlcMediaPlayer  = new VlcPlayer();
    AdvancedMediaPlayer aviMediaPlayer =  new AviPlayer();

    @Override
    public void play(String videoType, String fileName) {
        if(videoType.equalsIgnoreCase("vlc"))
        {
            vlcMediaPlayer.playVlc(fileName);
        }
        else if(videoType.equalsIgnoreCase("avi"))
        {
            aviMediaPlayer.playAvi(fileName);
        }
    }
}
