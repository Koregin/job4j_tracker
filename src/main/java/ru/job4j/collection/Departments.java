package ru.job4j.collection;

import com.sun.source.tree.BreakTree;

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
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                List<String> tmp1 = Arrays.asList(o1.split("/"));
                List<String> tmp2 = Arrays.asList(o2.split("/"));
                if (tmp1.get(0).equals(tmp2.get(0))) {
                    return o1.compareTo(o2);
                }
                return new DepDescComp().compare(o1, o2);
            }
        };
        Collections.sort(orgs, comparator);
    }
}
