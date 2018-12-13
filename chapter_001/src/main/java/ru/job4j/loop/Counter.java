package ru.job4j.loop;

/**
 * Класс счетчик
 *
 * @author Viktor Shiayn
 * @since 13.12.2018
 */
public class Counter {
    /**
     * Метод вычисляющий сумму четных чисел из диапозона
     *
     * @param start  начало диапозона
     * @param finish конец диапозона
     * @return сумма всех четных чисел
     */
    public int add(int start, int finish) {
        int count = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                count += i;
            }
        }
        return count;
    }
}
