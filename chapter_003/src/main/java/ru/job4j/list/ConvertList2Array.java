package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс разбивающий list на двумерный массив
 *
 * @author Viktor Shiyan
 * @since 05.01.2019
 */
public class ConvertList2Array {
    /**
     * Метод рабивающий список на двумерный массив
     *
     * @param list входной список
     * @param rows количество массивов
     * @return двумерный массив
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / (double) rows);
        int count = 0;
        int[][] array = new int[rows][cells];
        for (int out = 0; out < rows; out++) {
            for (int in = 0; in < cells; in++) {
                if (count >= list.size()) {
                    count++;
                } else {
                    array[out][in] = list.get(count);
                    count++;
                }
            }
        }
        return array;
    }

    /**
     * Метод объединяет в один список значения из списка массивов
     *
     * @param list входной список массивов со значениями
     * @return список
     */
    public List<Integer> convert(List<int[]> list) {
        ArrayList<Integer> listResult = new ArrayList<Integer>();
        for (int[] arr : list) {
            for (int item : arr) {
                listResult.add(item);
            }
        }
        return listResult;
    }
}
