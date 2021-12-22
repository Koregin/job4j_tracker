package ru.job4j.lambda;

import java.util.Optional;

public class OptionalIfPresent {

    public static void ifPresent(int[] data) {
        max(data).ifPresent(max -> System.out.println("Max: " + max));
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
            optional = Optional.of(max);
        }
        return optional;
    }
}
