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
        int size = data[0].length;
        if (size % 2 == 0) {
            result = this.monoEven(data, size);
        } else {
            result = this.monoNotEven(data, size);
        }
        return result;
    }

    /**
     * Метод для проверки диагоналей в матрице с не четным размером
     *
     * @param data матрица
     * @param size размер матрицы
     * @return true если диагонали одинаковы по значениям
     */
    private boolean monoNotEven(boolean[][] data, int size) {
        boolean result = true;
        int centr = (size - 1) / 2;
        boolean tmp = data[centr][centr];
        for (int i = 0; i <= centr; i++) {
            if (tmp != data[centr + i][centr + i] || tmp != data[centr - i][centr - i]
                    || tmp != data[centr + i][centr - i] || tmp != data[centr - i][centr + i]) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Метод для проверки диагоналей в матрице с четным размером
     *
     * @param data матрица
     * @param size размер матрицы
     * @return true если диагонали одинаковы по значениям
     */
    private boolean monoEven(boolean[][] data, int size) {
        boolean result = true;
        boolean tmpLeft;
        boolean tmpRight;
        tmpLeft = data[0][0];
        tmpRight = data[0][size - 1];
        for (int i = 0; i < size; i++) {
            if (data[i][i] != tmpLeft) {
                result = false;
                break;
            }
            if (data[i][size - 1 - i] != tmpRight) {
                result = false;
                break;
            }
        }
        return result;
    }
}