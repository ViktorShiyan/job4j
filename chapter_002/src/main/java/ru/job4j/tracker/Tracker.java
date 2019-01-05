package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Random;

public class Tracker implements TrackerInterface {
    private ArrayList<Item> items = new ArrayList<>();
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
                this.items.add(this.items.indexOf(i), item);
                this.items.remove(i);
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
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                this.items.remove(item);
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
    public ArrayList<Item> findAll() {
        return this.items;
    }

    /**
     * Поиск заявок по названию
     *
     * @param key название
     * @return массив с заявками
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return (result);
    }

    /**
     * Метод для поиска заявки по ID
     *
     * @param id идентификатор
     * @return Заявку или null
     */
    public Item findById(String id) {
        Item findItem = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                findItem = item;
            }
        }
        return findItem;
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
