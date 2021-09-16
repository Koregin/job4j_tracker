package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String project;

    Engineer(String n, String s, String e, String b, String p) {
        super(n, s, e, b);
        this.project = p;
    }

    public String getProject() {
        return this.project;
    }

    public Order perform(Customer customer) {
        return new Order();
    }
}
