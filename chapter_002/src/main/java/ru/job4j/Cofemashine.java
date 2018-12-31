package ru.job4j;


import java.util.Arrays;

/**
 * Класс реадизующий кофе машину
 *
 * @author Viktor Shiayn
 * @since 31.12.2018
 */
public class Cofemashine {
    private int[] coints = new int[]{5000, 1000, 500, 100, 50, 10, 5, 2, 1};


    /**
     * Метод возвращающий сдачу
     *
     * @param value внесенные деньги
     * @param price цена товара
     * @return массив с купюрами
     */
    int[] changes(int value, int price) {
        int[] cointRemain = new int[100];
        int remPosition = 0;
        int remainder = value - price;
        for (int c : coints) {
            while (remainder >= c) {
                cointRemain[remPosition++] = c;
                remainder -= c;
            }
        }
        return Arrays.copyOfRange(cointRemain, 0, remPosition);
    }

}
