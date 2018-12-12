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
    public int maxOfTwo(int first, int second) {
        return first > second ? first : second;
    }
}
