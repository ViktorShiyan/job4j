package ru.job4j.array;

/**
 * Класс для проверки массива boolean
 * на заполнение только true  или false
 *
 * @author Viktor Shiayn
 * @since 15.12.2018
 */
public class Check {
    /**
     * Метод для определения заполнен массив одинаковыми значениями
     * или разными
     *
     * @param data массив с данными
     * @return true если все значения одинаковы
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
