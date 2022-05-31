package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAdd() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("Item1");
        hbmTracker.add(item);
        assertThat(hbmTracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplace() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("item1");
        hbmTracker.add(item);
        Item newItem = new Item("item1new");
        hbmTracker.replace(1, newItem);
        assertThat(hbmTracker.findAll().get(0), is(newItem));
    }

    @Test
    public void whenDeleteItem() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("item1");
        hbmTracker.add(item);
        hbmTracker.delete(1);
        assertTrue(hbmTracker.findAll().isEmpty());
    }

    @Test
    public void whenFindAllItems() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        hbmTracker.add(item1);
        hbmTracker.add(item2);
        assertEquals(List.of(item1, item2), hbmTracker.findAll());
    }

    @Test
    public void whenFindByName() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        hbmTracker.add(item1);
        hbmTracker.add(item2);
        assertThat(hbmTracker.findByName("item2").get(0), is(hbmTracker.findAll().get(1)));
    }

    @Test
    public void whenFindItemById() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        hbmTracker.add(item1);
        hbmTracker.add(item2);
        assertThat(hbmTracker.findById(1), is(item1));
    }

}