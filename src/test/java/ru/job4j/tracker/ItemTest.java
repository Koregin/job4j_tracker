package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void sortItemTest() {
        List<Item> notSortedItems = Arrays.asList(
                new Item(3, "test3"),
                new Item(1, "test1"),
                new Item(2, "test2"),
                new Item(5, "test5"),
                new Item(4, "test4")
        );
        List<Item> sortedItems = Arrays.asList(
                new Item(1, "test1"),
                new Item(2, "test2"),
                new Item(3, "test3"),
                new Item(4, "test4"),
                new Item(5, "test5")
        );
        Collections.sort(notSortedItems, new SortAscItemId());
        assertEquals(notSortedItems, sortedItems);
    }

    @Test
    public void sortItemDescTest() {
        List<Item> notSortedItems = Arrays.asList(
                new Item(3, "test3"),
                new Item(1, "test1"),
                new Item(2, "test2"),
                new Item(5, "test5"),
                new Item(4, "test4")
        );
        List<Item> sortedItems = Arrays.asList(
                new Item(5, "test5"),
                new Item(4, "test4"),
                new Item(3, "test3"),
                new Item(2, "test2"),
                new Item(1, "test1")
        );
        Collections.sort(notSortedItems, new SortDescItemId());
        assertEquals(notSortedItems, sortedItems);
    }
}