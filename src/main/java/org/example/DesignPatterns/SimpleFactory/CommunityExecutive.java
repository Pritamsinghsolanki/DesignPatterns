package org.example.DesignPatterns.SimpleFactory;

//concrete product
public class CommunityExecutive implements Interviewer{
    @Override
    public void askQuestions() {
        System.out.println("Ask Community building related problems!");
    }
}
