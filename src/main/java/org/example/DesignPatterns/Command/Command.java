package org.example.DesignPatterns.Command;

//command interface
interface Command {
    void execute();
    void undo();
    void redo();
}
