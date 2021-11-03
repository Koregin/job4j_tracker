package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void whenMatrixToListConvert() {
        Integer[][] matrix = {
                {16, 3, 2, 15},
                {5, 10, 11, 8},
                {9, 6, 7, 12},
                {4, 15, 14, 1}
        };
        List<Integer> expected = List.of(
                16, 3, 2, 15,
                5, 10, 11, 8,
                9, 6, 7, 12,
                4, 15, 14, 1
        );
        assertEquals(expected, MatrixToList.matrixToList(matrix));
    }
}