package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String orientation;

    Builder(String n, String s, String e, String b, String p, String o) {
        super(n, s, e, b, p);
        this.orientation = o;
    }

    public void buildHouse() {
        System.out.println("I am building a house");
    }

    public boolean canBuild(Order order) {
        return false;
    }
}
