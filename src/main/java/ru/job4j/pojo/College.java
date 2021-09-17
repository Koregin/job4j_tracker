package ru.job4j.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Koregin Evgeny Vladimirovich");
        student.setGroup("Intern");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date dateAdmission;
        try {
            dateAdmission = dateFormat.parse("16.08.2021");
            student.setAdmission(dateAdmission);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(student.getFio() + " поступил в группу "
                + student.getGroup() + " " + student.getAdmission());
    }
}
