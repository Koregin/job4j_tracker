package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOfNullable {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> optional = Optional.empty();
        for (String str : strings) {
            if (Optional.ofNullable(str).equals(Optional.ofNullable(value))) {
                optional = Optional.ofNullable(str);
            }
        }
        return optional;
    }
}
