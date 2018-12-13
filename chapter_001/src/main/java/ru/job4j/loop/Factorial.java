package ru.job4j.loop;

/**
 * Класс вычисляющий факториал
 *
 * @author Viktor Shiayn
 * @since 13.12.2018
 */
public class Factorial {
    /**
     * Метод расчитывающий факториал
     *
     * @param n число для вычисления факториала
     * @return факториал от n
     */
    public int calc(int n) {
        int rsl = 1;
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                rsl *= i;
            }
        }
        return rsl;
    }
}
