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
        this.array = this.convertEvenArray(array);
    }

    @Override
    public boolean hasNext() {
        return index < this.array.length;
    }

    @Override
    public Object next() {
        int result;
        if (this.hasNext()) {
            result = this.array[this.index++];
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

    /**
     * Приобразуем массив с случайными числами в четный массив
     *
     * @param array входной массив
     * @return четный массив
     */
    private int[] convertEvenArray(int[] array) {
        long length = Arrays.stream(array).filter(x -> x % 2 == 0).count();
        int[] arrayRes = new int[Math.toIntExact(length)];
        int index = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                arrayRes[index] = i;
                index++;
            }
        }
        return arrayRes;
    }
}
