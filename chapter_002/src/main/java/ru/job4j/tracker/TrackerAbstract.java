package ru.job4j.tracker;

/**
 * Абстрактный класс, создан для уменьшения рукописного кода
 * реализует интерфейс TrackerInterface
 * В этом абстрактном классе используется принцип композиции
 */
public abstract class TrackerAbstract implements TrackerInterface {
    private Tracker tracker = new Tracker();

    @Override
    public Item add(Item item) {
        return this.tracker.add(item);
    }

    @Override
    public Item[] findAll() {
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
    public Item[] findByName(String key) {
        return this.tracker.findByName(key);
    }
}
