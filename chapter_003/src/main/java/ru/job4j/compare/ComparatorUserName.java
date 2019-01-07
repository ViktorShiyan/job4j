package ru.job4j.compare;

import java.util.Comparator;

/**
 * Компаратор для сортировки по имени
 *
 * @author Viktor Shiyan
 * @since 19.02.18
 */
public class ComparatorUserName implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}