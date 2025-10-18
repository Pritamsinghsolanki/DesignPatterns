package org.example.DesignPatterns.Iterator;

import java.util.ArrayList;
import java.util.List;
public class BookShelf implements Collection{
    private List<String> books  = new ArrayList<>();
    public void addBook(String book){
        books.add(book);
    }
    @Override
    public Iterator createIterator() {
        return new BookShelfIterator(this);
    }

    public List<String> getBooks(){
        return books;
    }
}
