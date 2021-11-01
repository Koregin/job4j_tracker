package ru.job4j.lambda;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalOrElseTest {

    @Test
    public void test() {
        assertEquals(Integer.valueOf(-1), OptionalOrElse.orElse(Optional.empty()));
        assertEquals(Integer.valueOf(1), OptionalOrElse.orElse(Optional.of(1)));
    }

}