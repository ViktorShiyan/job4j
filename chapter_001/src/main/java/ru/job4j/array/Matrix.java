package ru.job4j.array;

/**
 * Класс строящий таблицу умножения
 *
 * @author Viktor Shiyan
 * @since 15.12.2018
 */
public class Matrix {
    /**
     * Метод формирующий массив таблицы умножения
     *
     * @param size размер таблицы
     * @return двумерный массив с таблицей умножения
     */
    public int[][] multiple(int size) {
        int[][] res = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                res[i][j] = (i + 1) * (j + 1);
            }
        }
        return res;
    }
}
