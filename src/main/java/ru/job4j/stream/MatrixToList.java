package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Пример конвертации двумерного числового массива в список
 * @author EVGENY KOREGIN
 * @version 1.0
 */

public class MatrixToList {
    /**
     * Метод принимает на вход двумерный массив целых чисел
     * и возвращает список этих чисел
     * @param matrix двумерный массив
     * @return возвращает список целочисленных значений
     */
    public static List<Integer> matrixToList(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
