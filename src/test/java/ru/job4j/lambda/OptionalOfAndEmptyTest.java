package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalOfAndEmptyTest {

    @Test
    public void whenExists() {
        Assert.assertEquals(
                Optional.of("c"),
                OptionalOfAndEmpty.findValue(
                        Arrays.asList("a", "b", "c"),
                        "c"
                )
        );
    }

    @Test
    public void whenNotExists() {
        Assert.assertEquals(
                Optional.empty(),
                OptionalOfAndEmpty.findValue(
                        Arrays.asList("a", "b", "c"),
                        "d"
                )
        );
    }

}