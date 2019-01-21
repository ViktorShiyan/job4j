package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Класс реализующий очередь на двух стеках
 *
 * @param <T> тип хранимых элементов
 * @author Viktor Shiayn
 * @since 21.01.2019
 */
public class SimpleQueue<T> {

    private SimpleStack<T> stackIn = new SimpleStack<>();
    private SimpleStack<T> stackOut = new SimpleStack<>();
    private int size = 0;

    /**
     * Метод возвращает первое вошедшее значение
     *
     * @return первое вошедшее значение
     */
    public T poll() {
        if (!stackIn.isEmpty() && stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.poll());
            }
        }
        if (stackOut.isEmpty()) {
            throw new NoSuchElementException("noSuchElement");
        }
        this.size--;
        return stackOut.poll();
    }

    /**
     * Добавление элемента
     *
     * @param value элемент
     */
    public void push(T value) {
        stackIn.push(value);
        size++;
    }

    public int getSize() {
        return this.size;
    }
}
