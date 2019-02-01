package ru.job4j.io;

import java.io.InputStream;

/**
 * Класс для проверки является ли число в потоке четным
 *
 * @author ViktorShiyan
 * @since 30.01.2019
 */
public class EventStream {
    /**
     * Метод проверяет является ли число в потоке четным
     *
     * @param in поток ввода
     * @return true если число четное
     */
    public boolean isNumber(InputStream in) {
        boolean result = false;
        try {
            int i = in.read();
            if (i % 2 == 0) {
                result = true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
