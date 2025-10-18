package org.example.DesignPatterns.Adapter;

public class VideoPlayer implements MediaPlayer{
    MediaAdapter mediaAdapter = new MediaAdapter();


    @Override
    public void play(String videoType, String fileName) {
        if(videoType.equalsIgnoreCase("mp4")){
            System.out.println("Playing mp4 file Name: "+ fileName);
        }
        else if(videoType.equalsIgnoreCase("vlc") || videoType.equalsIgnoreCase("avi"))
        {
            mediaAdapter.play(videoType, fileName);
        }
        else {
            System.out.println("Invalid media. "+ videoType+ " format not supported");
        }

    }
}
