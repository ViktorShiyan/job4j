package ru.job4j;


import java.util.ArrayList;

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
        ArrayList<Integer> cointRemain = new ArrayList<Integer>();
        int remainder = value - price;
        for (int c : coints) {
            while (remainder >= c) {
                cointRemain.add(c);
                remainder -= c;
            }
        }
        return convertIntegers(cointRemain);
    }

    /**
     * Метод для преобразования списка в массив
     *
     * @param integers список
     * @return массив
     */
    public static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }
}
