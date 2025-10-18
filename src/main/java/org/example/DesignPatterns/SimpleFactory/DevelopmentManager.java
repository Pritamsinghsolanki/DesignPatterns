package org.example.DesignPatterns.SimpleFactory;

public class DevelopmentManager extends HiringManager{
    @Override
    protected Interviewer makeInterviewer() {
        return new Developer();
    }
}
