package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private static final Random RN = new Random();
    private int position;

    public Tracker() {
        this.position = 0;
    }

    /**
     * Метод для добавления заявок
     *
     * @param item заявка
     * @return заявку с присвоенным ID
     */
    public Item add(Item item) {
        item.setId(this.generateID());
        this.items[position] = item;
        position++;
        return item;
    }

    /**
     * Метод изменяющий заявку
     *
     * @param id   изменяемая заявка
     * @param item новая заявка
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                item.setId(id);
                this.items[i] = item;
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод удаляющий заявку
     *
     * @param id идентификатор удаляемой заявки
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, position - 1);
                position -= 1;
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOfRange(this.items, 0, position);
    }

    public Item[] findByName(String key) {
        int inPosition = 0;
        Item[] findByNameArr = new Item[100];
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                findByNameArr[inPosition] = this.items[i];
                inPosition++;
            }
        }
        return Arrays.copyOfRange(findByNameArr, 0, inPosition);
    }

    public Item findById(String id) {
        Item findItem = null;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                findItem = this.items[i];
                break;
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
