package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * Интерфейс для классов Трекер.
 * Создан для того, что бы не писать методы в ручную.
 *
 * @author Viktor Shiyan
 * @since 28.12.2018
 */
public interface TrackerInterface {
    Item add(Item item);

    ArrayList<Item> findAll();

    boolean delete(String id);

    boolean replace(String id, Item item);

    Item findById(String id);

    ArrayList<Item> findByName(String key);
}
