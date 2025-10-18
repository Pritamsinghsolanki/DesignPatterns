package org.example.DesignPatterns.SimpleFactory;

abstract class HiringManager {
    protected abstract Interviewer makeInterviewer();

    public void takeInterview(){
        Interviewer interviewer = makeInterviewer();
        interviewer.askQuestions();
    }
}
