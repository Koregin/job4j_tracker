package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private int countOfoperations;

    Surgeon(String n, String s, String e, String b, String spec, int count) {
        super(n, s, e, b, spec);
        this.countOfoperations = count;
    }

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
