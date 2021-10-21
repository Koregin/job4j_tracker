package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;

public class JobTest {
    @Test
    public void jobCompAscByNameTest() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("A", 2),
                new Job("B", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void jobCompDescByNameTest() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("A", 2),
                new Job("B", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void jobCompAscByPriorityTest() {
        Comparator<Job> cmpName = new JobAscByPriority();
        int rsl = cmpName.compare(
                new Job("A", 2),
                new Job("B", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void jobCompDescByPriorityTest() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("A", 2),
                new Job("B", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityAndName() {
        Comparator<Job> cmpName = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpName.compare(
                new Job("A", 2),
                new Job("B", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}