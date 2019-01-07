package ru.job4j.compare;

import java.util.Comparator;

/**
 * Компаратор для сравнения строк
 *
 * @author Viktor Shiyan
 * @since 07.01.2019
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int lengthMin = (left.length() < right.length()) ? left.length() : right.length();
        for (int i = 0; i < lengthMin; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = left.length() - right.length();
        }
        return result;
    }
}
