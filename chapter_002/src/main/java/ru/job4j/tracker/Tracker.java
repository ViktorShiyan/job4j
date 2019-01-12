package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Tracker implements TrackerInterface {
    private List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    public Tracker() {
    }

    /**
     * Метод для добавления заявок
     *
     * @param item заявка
     * @return заявку с присвоенным ID
     */
    public Item add(Item item) {
        item.setId(this.generateID());
        this.items.add(item);
        return item;
    }

    /**
     * Метод изменяющий заявку
     *
     * @param id   изменяемая заявка
     * @param item новая заявка
     * @return true при успешном изменении
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (Item i : this.items) {
            if (i.getId().equals(id)) {
                item.setId(id);
                this.items.set(this.items.indexOf(i), item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляющий заявку
     *
     * @param id идентификатор удаляемой заявки
     * @return true при удачном удалении
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод для получения всех заявок
     *
     * @return все заявки
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Поиск заявок по названию
     *
     * @param key название
     * @return массив с заявками
     */
    public List<Item> findByName(String key) {
        return this.items.stream().filter(item -> item.getName().equals(key)).collect(Collectors.toList());
    }

    /**
     * Метод для поиска заявки по ID
     *
     * @param id идентификатор
     * @return Заявку или null
     */
    public Item findById(String id) {
        Item itemFind = null;
        List<Item> list = this.items.stream().filter(item -> item.getId().equals(id)).collect(Collectors.toList());
        if (!list.isEmpty()) {
            itemFind = list.get(0);
        }
        return itemFind;
    }

    /**
     * Метод генерирующий Id
     * в милисикундах прлюс случайное число
     *
     * @return id
     */
    private String generateID() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
