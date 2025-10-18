package org.example.DesignPatterns.Observer;

interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyOservers(JobPost job);
}
