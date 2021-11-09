package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String For Interface";
        System.out.println(sup.get());
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept(sup.get());
        BiConsumer<String, String> biconsumer = (s, s1) -> System.out.println(s + s1);
        biconsumer.accept(sup.get(), " and Second String");

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supSet = () -> new HashSet<>(list);
        BiConsumer<Integer, String> stringBiConsumer = (s, s1) -> System.out.println(s + s1);
        Set<String> strings = supSet.get();
        int i = 1;
        for (String s : strings) {
            stringBiConsumer.accept(i++, " is " + s);
        }

        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("String is empty: " + pred.test(""));
        System.out.println("String is empty: " + pred.test("test"));

        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: "
                + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: "
                + builder.apply(new StringBuilder("tset rof gnirtS")));

        BinaryOperator<StringBuilder> builder2 = (b1, b2) -> b1.append(" ")
                                                                .append(b2);
        System.out.println(
                "Строка после объединения: " + builder2.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
