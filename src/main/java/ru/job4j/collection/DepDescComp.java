package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = right.split("/")[0].compareTo(left.split("/")[0]);
        return rsl == 0 ? left.compareTo(right) : rsl;
    }
}
