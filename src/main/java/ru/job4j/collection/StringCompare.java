package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int res = 0;
        for (int index = 0; index < left.length(); index++) {
            if (index == right.length()) {
                res = 1;
                break;
            } else if (index == left.length() - 1 && right.length() > left.length()) {
                res = -1;
                break;
            }
            res = Character.compare(left.charAt(index), right.charAt(index));
            if (res != 0) {
                break;
            }
        }
        return res;
    }
}
