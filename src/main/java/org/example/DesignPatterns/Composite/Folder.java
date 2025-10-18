package org.example.DesignPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements File{
    private String name;
    private List<File> children  = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }
    @Override
    public void show() {
        System.out.println("Folder:"+ name);
        for(File file: children){
            file.show();
        }
    }

    @Override
    public void add(File file) {
         children.add(file);
    }
}
