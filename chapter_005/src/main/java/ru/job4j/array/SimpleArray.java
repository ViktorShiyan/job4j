package ru.job4j.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс реализующий простой список
 *
 * @author Viktor Shiyan
 * @since 15.01.2019
 */
public class SimpleArray<T> implements Iterable {
    private Object[] array;
    private int index = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Метод добавления элемента
     *
     * @param model элемент для добавления
     */
    public void add(T model) {
        if (this.index >= this.array.length) {
            throw new RuntimeException("error");
        }
        this.array[index++] = model;
    }

    /**
     * Метод длявставки элемента по индексу
     *
     * @param index индекс
     * @param model элемент
     */
    public void set(int index, T model) {
        if (index >= this.index || index < 0) {
            throw new RuntimeException("error");
        }
        this.array[index] = model;
    }

    /**
     * Метод удаляющий обьект со сдвигом
     *
     * @param index индекс удаляемого объекта
     */
    public void remove(int index) {
        if (this.index > 0 && index < this.index) {
            this.index--;
            System.arraycopy(this.array, index + 1, this.array, index, this.array.length - index - 1);
        } else {
            throw new RuntimeException("error");
        }
    }

    /**
     * Метод для получения элемента по индексу
     *
     * @param index индекс
     * @return элемент из списка
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (this.index > 0 && index < this.index) {
            return (T) this.array[index];
        } else {
            throw new RuntimeException("error");
        }

    }

    /**
     * Iterator
     *
     * @return итератор списка
     */
    @SuppressWarnings("unchecked")
    public Iterator iterator() {
        return new IteratorSimple((T[]) this.array, this.index);
    }

    /**
     * Класс итератор
     */
    class IteratorSimple implements Iterator<T> {
        private final T[] array;
        int end;
        int index = 0;

        IteratorSimple(T[] array, int size) {
            this.array = array;
            this.end = size;
        }

        @Override

        public boolean hasNext() {
            return index < this.end;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return this.array[index++];
            } else {
                throw new NoSuchElementException("error");
            }
        }
    }
}
