package ru.job4j.inheritance;

public class Builder extends Engineer {

    public boolean canBuild(Order order) {
        return false;
    }
}
