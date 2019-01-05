package ru.job4j.search;

import java.util.LinkedList;

/**
 * Класс описывающий очередь с приоритетом
 *
 * @author Viktor Shiyan
 * @since 04.01.2019
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        for (Task t : tasks) {
            if (t != null && t.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}