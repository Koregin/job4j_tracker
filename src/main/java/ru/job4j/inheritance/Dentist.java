package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private boolean implantologist;
    private boolean dentistSurgeon;

    Dentist(String n, String s, String e, String b, String sp, boolean i, boolean d) {
        super(n, s, e, b, sp);
        this.implantologist = i;
        this.dentistSurgeon = d;
    }

    public boolean removeTooth(Diagnosis diagnosis) {
        return false;
    }

    public void treatTeeth() {
        System.out.println("I am treating teeth");
    }
}
