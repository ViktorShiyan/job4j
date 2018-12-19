package ru.job4j.array;

import ru.job4j.array.BubbleSort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Класс реализующий разделение массива на два
 * где сумма элементов в каждом массиве равна
 * или максимально близка к равенству
 *
 * @author Viktor Shiayn
 * @since 18.12.2018
 */
public class Spliter {

    /**
     * Метод для разделения массива
     *
     * @param data входной массив
     * @return массив с двумя массивами
     */
    public int[][] splitEqualy(int[] data) {
        BubbleSort sorter = new BubbleSort();
        int[][] result = new int[2][];
        data = sorter.sort(data);
        int sumLeft;
        int sumRight;
        for (int i = 1; i < data.length; i++) {
            sumLeft = this.sum(data, 0, i);
            sumRight = this.sum(data, i + 1, data.length - 1);
            if (sumLeft > sumRight) {
                result[0] = Arrays.copyOfRange(data, 0, i);
                result[1] = Arrays.copyOfRange(data, i, data.length);
            }
        }
        return result;
    }

    /**
     * Метод для сумирования среза массива
     *
     * @param data   входной массив
     * @param start  начало среза
     * @param finish конец среза
     * @return сумму
     */
    public int sum(int[] data, int start, int finish) {
        int sumArray = 0;
        for (int i = start; i <= finish; i++) {
            sumArray += data[i];
        }
        return sumArray;
    }
}
