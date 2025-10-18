package org.example.DesignPatterns.SimpleFactory;

public class MarketingManager extends HiringManager {
    @Override
    protected Interviewer makeInterviewer() {
        return new CommunityExecutive();
    }
}
