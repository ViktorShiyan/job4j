package ru.job4j.tracker.singletone;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ITracker;

import java.util.List;

/**
 * enum. Eager loading.
 * Реализация singleton с помощью enum
 * реализует интерфейс ITracker
 */
public enum TrackerEnumEager implements ITracker {
    INSTANCE;
    private Tracker tracker = new Tracker();

    @Override
    public Item add(Item item) {
        return this.tracker.add(item);
    }

    @Override
    public List<Item> findAll() {
        return this.tracker.findAll();
    }

    @Override
    public boolean delete(String id) {
        return this.tracker.delete(id);
    }

    @Override
    public boolean replace(String id, Item item) {
        return this.tracker.replace(id, item);
    }

    @Override
    public Item findById(String id) {
        return tracker.findById(id);
    }

    @Override
    public List<Item> findByName(String key) {
        return this.tracker.findByName(key);
    }
}
