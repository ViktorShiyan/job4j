package ru.job4j.tracker;

import java.util.List;

/**
 * Абстрактный класс, создан для уменьшения рукописного кода
 * реализует интерфейс ITracker
 * В этом абстрактном классе используется принцип композиции
 */
public abstract class TrackerAbstract implements ITracker {
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
