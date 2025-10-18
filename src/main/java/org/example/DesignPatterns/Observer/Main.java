package org.example.DesignPatterns.Observer;

public class Main {
    public static void main(String[] args){
        //create job seekers
        JobSeeker john = new JobSeeker("jOHN");
        JobSeeker jane = new JobSeeker("jane");

        EmploymentAgency agency = new EmploymentAgency();
        agency.attach(john);
        agency.attach(jane);

        agency.addJob(new JobPost("SE"));
    }
}
