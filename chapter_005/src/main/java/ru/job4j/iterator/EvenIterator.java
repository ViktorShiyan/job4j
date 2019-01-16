package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор четных чисел
 *
 * @author Viktor Shiyan
 * @since 15.01.2019
 */
public class EvenIterator implements Iterator {
    private final int[] array;
    private int index = 0;

    public EvenIterator(final int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean res = false;
        for (int i = this.index; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                res = true;
                this.index = i;
                break;
            }
        }
        return res;
    }

    @Override
    public Object next() {
        int result;
        if (this.hasNext()) {
            result = this.array[this.index];
            this.index++;
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
