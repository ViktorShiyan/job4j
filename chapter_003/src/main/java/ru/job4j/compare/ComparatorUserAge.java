package ru.job4j.compare;

import java.util.Comparator;

/**
 * Компаратор для сортировки по возрасту
 *
 * @author Viktor Shiyan
 * @since 07.01.2019
 */
public class ComparatorUserAge implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}