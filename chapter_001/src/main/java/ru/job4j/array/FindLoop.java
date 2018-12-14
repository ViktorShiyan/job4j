package ru.job4j.array;

/**
 * Класс для поиска индекса по значению в массиве
 *
 * @author Viktor Shiyan
 * @since 14.12.2018
 */
public class FindLoop {
    /**
     * Метод возвращает индекс искомого значения
     * если не находит то возвращает -1
     *
     * @param data массив для поиска
     * @param el   искомый элемент
     * @return индекс в массиве
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}