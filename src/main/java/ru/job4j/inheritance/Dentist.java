package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private boolean implantologist;
    private boolean dentistSurgeon;

    public boolean removeTooth(Diagnosis diagnosis) {
        return false;
    }

    public void treatTeeth() {
        System.out.println("I am treating teeth");
    }
}
