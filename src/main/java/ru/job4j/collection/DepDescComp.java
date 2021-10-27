package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        List<String> tmp1 = Arrays.asList(o1.split("/"));
        List<String> tmp2 = Arrays.asList(o2.split("/"));
        int rsl = tmp2.get(0).compareTo(tmp1.get(0));
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}
