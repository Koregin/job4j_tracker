package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String specialization;

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}
