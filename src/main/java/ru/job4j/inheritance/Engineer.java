package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String project;

    public String getProject() {
        return this.project;
    }

    public Order perform(Customer customer) {
        return new Order();
    }
}
