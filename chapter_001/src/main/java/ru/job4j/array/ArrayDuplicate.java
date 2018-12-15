package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс удаляющий дубликаты в массиве
 *
 * @author Viktor Shiyan
 * @since 15.12.2018
 */
public class ArrayDuplicate {

    /**
     * Метод реализующий удаление дубликатов массиве
     *
     * @param array входной массив
     * @return массив без дубликатов
     */
    public String[] remove(String[] array) {
        int uniq = array.length;
        for (int out = 0; out < uniq; out++) {
            for (int in = out + 1; in < uniq; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[uniq - 1];
                    uniq--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, uniq);
    }
}
