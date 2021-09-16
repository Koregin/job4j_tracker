package ru.job4j.inheritance;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    Profession(String n, String s, String e, String b) {
        this.name = n;
        this.surname = s;
        this.education = e;
        this.birthday = b;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEducation() {
        return this.education;
    }

    public String getBirthday() {
        return this.birthday;
    }
}
