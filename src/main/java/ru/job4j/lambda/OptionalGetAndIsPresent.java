package ru.job4j.lambda;

import java.util.Optional;

public class OptionalGetAndIsPresent {

    public static int get(int[] data, int el) {
        Optional<Integer> res = indexOf(data, el);
        return res.isPresent() ? res.get() : -1;
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        Optional<Integer> optional = Optional.empty();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                optional = Optional.of(i);
            }
        }
        return optional;
    }
}
