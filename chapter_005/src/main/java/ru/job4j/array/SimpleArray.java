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
            throw new RuntimeException("Переполнение");
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
            throw new RuntimeException("Индекс за пределами");
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
            throw new RuntimeException("Нет элемента для удаления с таким индексом");
        }
    }

    /**
     * Метод для получения элемента по индексу
     *
     * @param index индекс
     * @return элемент из списка
     */
    public T get(int index) {
        return (T) this.array[index];
    }

    /**
     * Итератор
     *
     * @return итератор списка
     */
    @Override
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
                throw new NoSuchElementException("No");
            }
        }
    }
}
