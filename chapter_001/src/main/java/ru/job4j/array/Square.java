package ru.job4j.array;

/**
 * Класс который заполняет массив квадратов
 *
 * @author Viktor Shiayn
 * @since 14.12.2018
 */
public class Square {
    /**
     * Метод заполняющий массив квадратами чисел
     *
     * @param bound конец диапозона
     * @return массив квадратов
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (int) Math.pow(i + 1, 2);
        }
        return rst;
    }
}