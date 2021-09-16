package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String language;
    private String level;

    public String getLanguage() {
        return this.language;
    }

    public void writeCode() {
        System.out.println("I am writing code!");
    }

    public boolean canWriteProgram(Order order) {
        return false;
    }
}
