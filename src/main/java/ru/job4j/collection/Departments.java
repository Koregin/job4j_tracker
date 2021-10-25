package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + el);
                start += el + "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {

    }

    public static void sortDesc(List<String> orgs) {

    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("K1", "K1/SK1/SSK1");
        List<String> result = Departments.fillGaps(list);
        for (String el : result) {
            System.out.println(el);
        }
    }
}
