package ru.job4j.lambda;

import java.util.Comparator;

/**
 * Пример лямбды с блоком
 * @author EVGENY KOREGIN
 * @version 1.0
 */
public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return right.compareTo(left);
        };
    }
}
