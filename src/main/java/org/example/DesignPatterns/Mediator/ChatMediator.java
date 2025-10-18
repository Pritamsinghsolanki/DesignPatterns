package org.example.DesignPatterns.Mediator;

interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
