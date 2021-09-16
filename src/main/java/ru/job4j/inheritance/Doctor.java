package ru.job4j.inheritance;

import javax.print.Doc;

public class Doctor extends Profession {
    private String specialization;

    Doctor(String n, String s, String e, String b, String spec) {
        super(n, s, e, b);
        this.specialization = spec;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}
