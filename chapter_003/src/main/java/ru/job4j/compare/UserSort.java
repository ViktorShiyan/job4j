package ru.job4j.compare;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс сортирующий пользователей
 *
 * @author Viktor Shiyan
 * @since 07.01.2019
 */
public class UserSort {
    /**
     * Метод возвращает отсортированных по возрасту пользователей
     *
     * @param userList список пользователей
     * @return отсортированное множество пользователей
     */
    public Set<User> sort(List<User> userList) {
        return new TreeSet<>(userList);
    }
}
