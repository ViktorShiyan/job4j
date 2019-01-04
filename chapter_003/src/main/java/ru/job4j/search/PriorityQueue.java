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
        if (this.tasks.isEmpty()) {
            this.tasks.add(task);
        } else {
            for (int i = 0; i < this.tasks.size(); i++) {
                if (task.getPriority() <= this.tasks.get(i).getPriority()) {
                    this.tasks.add(i, task);
                    break;
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}