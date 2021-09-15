package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String language;

    public String getLanguage() {
        return this.language;
    }

    public boolean canWriteProgram(Order order) {
        return false;
    }
}
