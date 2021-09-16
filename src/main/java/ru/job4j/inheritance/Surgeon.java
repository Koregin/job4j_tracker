package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private int countOfoperations;

    public int getCountOfoperations() {
        return this.countOfoperations;
    }

    public void operate() {
        System.out.println("I am doing an operating");
    }

    public boolean doOperation(Diagnosis diagnosis) {
        return true;
    }
}
