package ru.job4j.comparing;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс проверяющий состоят ли слова из одних букв
 *
 * @author ViktorShiayn
 * @since 05.02.2019
 */
public class StringCompare {
    /**
     * Метод для сравнения строк
     *
     * @param first  первая строка
     * @param second вторая строка
     * @return из одних ли букв состоят слова
     */
    public boolean stringCompare(String first, String second) {
        Map<Character, Integer> tamp = new HashMap<>();
        for (Character ch : first.toCharArray()) {
            tamp.putIfAbsent(ch, Character.getNumericValue(ch));
        }
        char[] charArray = second.toCharArray();
        for (Character chTemp : charArray) {
            tamp.remove(chTemp);
        }
        return tamp.size() == 0;
    }
}
