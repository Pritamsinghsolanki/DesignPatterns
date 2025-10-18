package org.example.DesignPatterns.Prototype;

public class PrototypeMain {
    public static void main(String[] args)
    {
        ShapeCache.loadCache();

        Shape cloneShape1 = ShapeCache.getShape("1");
        System.out.println("Shape: "+ cloneShape1.getType());

        Shape cloneShape2 = ShapeCache.getShape("2");
        System.out.println("Shape: "+ cloneShape2.getType());

    }
}
