package org.example.DesignPatterns.Momento;

public class TextEditor {
    private StringBuilder content = new StringBuilder();

    public void type(String words){
        content.append(words);
    }

    public String getContent(){
        return content.toString();
    }

    public Momento save(){
        return new Momento(content.toString());
    }

    public void restore(Momento momento){
        content = new StringBuilder(momento.getState());
    }
}
