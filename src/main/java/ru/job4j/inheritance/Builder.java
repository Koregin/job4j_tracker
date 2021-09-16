package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String orientation;

    public void buildHouse() {
        System.out.println("I am building a house");
    }

    public boolean canBuild(Order order) {
        return false;
    }
}
