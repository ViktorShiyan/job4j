package ru.job4j.list;

import java.util.List;

/**
 * Класс разбивающий list на двумерный массив
 *
 * @author Viktor Shiyan
 * @since 05.01.2019
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / (double) rows);
        int count = 0;
        int[][] array = new int[rows][cells];
        for (int out = 0; out < rows; out++) {
            for (int in = 0; in < cells; in++) {
                if (count >= list.size()) {
                    array[out][in] = 0;
                    count++;
                } else {
                    array[out][in] = list.get(count);
                    count++;
                }
            }
        }
        return array;
    }
}
