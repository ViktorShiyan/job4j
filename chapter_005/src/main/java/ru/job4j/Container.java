package ru.job4j;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс реализующий контейнер для хранения
 *
 * @param <E> тип принимаемых объектов
 * @author Viktor Shiyan
 * @since 18.01.2019
 */
public class Container<E> implements Iterable<E> {
    /**
     * Массив для хранения
     */
    private Object[] container;
    /**
     * Позиция коретки
     */
    private int position = 0;
    /**
     * Размер контейнера
     */
    private int size = 1;

    private int modCount = 0;

    /**
     * Конструктор без параметров
     */
    public Container() {
        container = new Object[this.size];
    }

    /**
     * Конструктор с параметром
     *
     * @param size размер внутреннего массива
     */
    public Container(int size) {
        container = new Object[size];
    }

    /**
     * Добавление элемента
     *
     * @param value элемент
     */
    public void add(E value) {
        if (this.position == this.container.length) {
            this.arrayIncrease();
        }
        this.container[this.position++] = value;
        modCount++;
    }

    /**
     * Метод получения элемента по индексу
     *
     * @param index индекс элеимента
     * @return элемент
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index > this.position && this.position == 0) {
            throw new RuntimeException("error");
        }
        return (E) this.container[index];
    }

    /**
     * Метод увеличивающий размер контейнера
     */
    private void arrayIncrease() {
        size *= 2;
        this.container = Arrays.copyOf(this.container, size);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<E> iterator() {
        return new IteratorCont((E[]) this.container, this.modCount);
    }

    /**
     * Итератор с возможностью отслеживания модификаций
     */
    private class IteratorCont implements Iterator<E> {
        private E[] array;
        private int expectedModCount;
        private int index = 0;

        public IteratorCont(E[] array, int modCount) {
            this.array = array;
            this.expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            return index < position;
        }

        @Override
        public E next() {
            if (hasNext()) {
                if (this.expectedModCount != modCount) {
                    throw new RuntimeException("modification");
                }
                return this.array[index++];
            } else {
                throw new NoSuchElementException("error");
            }
        }
    }
}
