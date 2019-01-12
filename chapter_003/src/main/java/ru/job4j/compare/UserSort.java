package ru.job4j.compare;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * Метод сортирует список по длине имени
     *
     * @param list список пользователей
     * @return отсортированый список
     */
    public List<User> sortNameLength(List<User> list) {
        return list.stream().sorted(new ComporatorUserNameLenght()).collect(Collectors.toList());
    }

    /**
     * Метод сортировки по обоим полям,
     * сначала сортировка по имени в лексикографическом порядке, потом по возрасту.
     *
     * @param userList список пользователей
     * @return отсортированный список
     */
    public List<User> sortByAllFields(List<User> userList) {
        userList.sort(new ComparatorUserName().thenComparing(new ComparatorUserAge()));
        return userList.stream().sorted(new ComparatorUserName().thenComparing(new ComparatorUserAge())).collect(Collectors.toList());
    }
}
