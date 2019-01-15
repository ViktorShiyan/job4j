package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для двумерного массива
 *
 * @author Viktor Shiyan
 * @since 15.01.2019
 */
public class JaggedArrayIterator implements Iterator {
    private final int[][] array;
    private int out = 0;
    private int in = 0;

    public JaggedArrayIterator(final int[][] array) {
        this.array = array;

    }

    @Override
    public boolean hasNext() {
        return out < this.array.length && in < this.array[out].length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int res = array[out][in++];
        if (in >= array[out].length) {
            in = 0;
            out++;
        }
        return res;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
