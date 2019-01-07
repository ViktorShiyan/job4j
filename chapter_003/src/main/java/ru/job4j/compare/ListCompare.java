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
        int litleLenght = left.length() < right.length() ? left.length() : right.length();
        for (int i = 0; i < litleLenght; i++) {
            if (left.charAt(i) > right.charAt(i)) {
                result = 1;
                break;
            } else if (left.charAt(i) < right.charAt(i)) {
                result = -1;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = left.length() - right.length();
        }
        return result;
    }
}
