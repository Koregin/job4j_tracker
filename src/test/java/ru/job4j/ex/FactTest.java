package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenArgumentLessThanZero() {
        new Fact().calc(-2);
    }

    @Test
    public void whenTestSuccessful() {
        int rsl = new Fact().calc(5);
        assertThat(rsl, is(120));
    }
}