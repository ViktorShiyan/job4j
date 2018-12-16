package ru.job4j.array;

/**
 * Класс проверки диагоналей на одинаковость значений
 *
 * @author Viktor Shiayn
 * @since 15.12.2018
 */
public class MatrixCheck {
    /**
     * Метод проверяющий диагонали на одинаковость значений
     *
     * @param data матрица с данными
     * @return true если данные в диагоналях одинаковы
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int size = data[0].length - 1;
        for (int i = 0; i < size; i++) {
            if (data[i][i] != data[i + 1][i + 1] || data[i][size - i] != data[i + 1][size - i - 1]) {
                result = false;
                break;
            }

        }
        return result;
    }

}