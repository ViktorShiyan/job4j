package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Итератор для двумерного массива
 *
 * @author Viktor Shiyan
 * @since 15.01.2019
 */
public class JaggedArrayIterator implements Iterator {
    private final int[] array;
    private int index = 0;

    public JaggedArrayIterator(final int[][] array) {
        this.array = this.convert2Array(array);

    }

    @Override
    public boolean hasNext() {
        return index < this.array.length;
    }

    @Override
    public Object next() {
        return this.array[index++];
    }

    /**
     * Метод для преобразования двумерного массива в одномерный
     *
     * @param jaggedArray входной массив
     * @return значения входного массива в одномерном
     */
    private int[] convert2Array(int[][] jaggedArray) {
        int lenght = Arrays.stream(jaggedArray).mapToInt(x -> x.length).sum();
        int[] resultArray = new int[lenght];
        int index = 0;
        for (int[] out : jaggedArray) {
            for (int in : out) {
                resultArray[index] = in;
                index++;
            }
        }
        return resultArray;
    }
}
