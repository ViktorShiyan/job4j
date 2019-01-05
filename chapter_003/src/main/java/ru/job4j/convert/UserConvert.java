package ru.job4j.convert;

import java.util.HashMap;
import java.util.List;

/**
 * Класс реализующий метод преобразования List в Map
 *
 * @author Viktor Shiyan
 * @since 05.01.2019
 */
public class UserConvert {
    /**
     * Метод преобразующий список пользователей в Map пользователей
     *
     * @param list список пользователей
     * @return Map с пользователями
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userHashMap = new HashMap<Integer, User>();
        for (User user : list) {
            userHashMap.put(user.getId(), user);
        }
        return userHashMap;
    }
}
