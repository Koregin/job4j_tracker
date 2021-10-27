package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String For Interface";
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
    }
}
