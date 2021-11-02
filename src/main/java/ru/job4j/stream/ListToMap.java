package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static Map<String, Student> listtomap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(
                Collectors.toMap(
                        Student::getSurname,
                        e -> e
                ));
    }
}
