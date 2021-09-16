package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String language;
    private String level;

    Programmer(String n, String s, String e, String b, String p, String lang, String lvl) {
        super(n, s, e, b, p);
        this.language = lang;
        this.level = lvl;
    }

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
