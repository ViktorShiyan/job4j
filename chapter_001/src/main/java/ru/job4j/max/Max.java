package ru.job4j.max;

/**
 * Класс сравнивающий числа
 *
 * @author Viktor Shiyan
 * @since 12.12.2018
 */
public class Max {
    /**
     * Метод возвращающий большее из двух чисел
     *
     * @param first  первое число
     * @param second второе число
     * @return большее число
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Метод возвращающий большее из трех чисел
     *
     * @param first  первое число
     * @param second второе число
     * @param third  третье число
     * @return большее число
     */
    public int max(int first, int second, int third) {
        return this.max(first, this.max(second, third));
    }
}
