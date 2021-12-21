package ru.job4j.lambda;

import java.util.Optional;

public class OptionalIfPresent {

    public static void ifPresent(int[] data) {

    }

    private static Optional<Integer> max(int[] data) {
        Optional<Integer> optional = Optional.empty();
        if (data.length > 0) {
            int max = 0;
            for (int num : data) {
                if (num > max) {
                    max = num;
                }
            }
            optional.of(max);
        }
        return optional;
    }
}
