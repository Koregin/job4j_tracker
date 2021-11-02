package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ListToMapTest {
    @Test
    public void whenListToMapWithDuplicates() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9"),
                new Student(50, "Surname5"),
                new Student(10, "Surname1")
        );
        Map<String, Student> studentsMap = Map.of(
                "Surname1", new Student(10, "Surname1"),
                "Surname4", new Student(40, "Surname4"),
                "Surname5", new Student(50, "Surname5"),
                "Surname7", new Student(70, "Surname7"),
                "Surname9", new Student(90, "Surname9")
        );
        assertEquals(studentsMap, ListToMap.listtomap(students));
    }

}