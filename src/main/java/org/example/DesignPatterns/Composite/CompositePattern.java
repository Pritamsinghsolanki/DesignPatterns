package org.example.DesignPatterns.Composite;

public class CompositePattern {
    public static void main(String[] args)
    {
        File file1 = new TextFile("file1.txt");
        File file2 = new ImageFile("file2.jpg");

        Folder folder = new Folder("My Folder");
        folder.add(file1);
        folder.add(file2);

        folder.show();
    }
}
