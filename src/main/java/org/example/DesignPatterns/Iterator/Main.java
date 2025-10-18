package org.example.DesignPatterns.Iterator;

public class Main {
    public static void main(String[] args){
        BookShelf bookShelf = new BookShelf();
        bookShelf.addBook("Book 1");
        bookShelf.addBook("Book 2");
        bookShelf.addBook("Book 3");

        Iterator iterator = bookShelf.createIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
