package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс преобразует двумерный массив в список
 *
 * @author Viktor Shiyan
 * @since 05.01.2019
 */
public class ConvertMatrix2List {
    /**
     * Метод для преобразования двумерного массива в список
     * @param array входной массив
     * @return список элементов
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] outArray : array) {
            for (int i : outArray) {
                list.add(i);
            }
        }
        return list;
    }
}
