package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {
    private static SingleTracker uniqueInstance;

    private Store tracker = new MemTracker();

    public static SingleTracker getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingleTracker();
        }
        return uniqueInstance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
