package ru.job4j.compare;

import java.util.Comparator;

/**
 * Сравнивает длину имён пользователей
 *
 * @author Viktro Shiyan
 * @since 07.01.2019
 */
public class ComporatorUserNameLenght implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}
