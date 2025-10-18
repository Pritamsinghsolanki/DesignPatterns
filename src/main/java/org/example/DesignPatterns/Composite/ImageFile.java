package org.example.DesignPatterns.Composite;

public class ImageFile implements File{
    private String name;
    public ImageFile(String name){
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("ImageFile:"+ name);
    }

    @Override
    public void add(File file) {
        throw new UnsupportedOperationException("Cannot add to an ImageFile.");
    }
}
