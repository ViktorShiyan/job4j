package ru.job4j.search;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
        this.tasks.add(task);
        this.tasks = this.tasks.stream().sorted(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getPriority() - o2.getPriority();
            }
        }).collect(Collectors.toCollection(LinkedList::new));
    }

    public Task take() {
        return this.tasks.poll();
    }
}