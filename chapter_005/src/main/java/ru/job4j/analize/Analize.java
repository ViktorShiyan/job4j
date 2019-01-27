package ru.job4j.analize;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс анализатор списков
 *
 * @author Viktor Shiayn
 * @since 25.01.2019
 */
public class Analize {

    /**
     * Метод для определения изменений
     *
     * @param previous прошлое состояние
     * @param current  текущее состояние
     * @return новый экземпляр информации
     */
    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, String> currentUser = current.stream().collect(Collectors.toMap(User::getId, User::getName));
        Info info = new Info(0, 0, 0);
        String temp;
        for (User user : previous) {
            temp = currentUser.remove(user.getId());
            if (temp == null) {
                info.deleted++;
            } else if (!temp.equals(user.getName())) {
                info.changed++;
            }
        }
        info.added = currentUser.size();
        return info;
    }

    /**
     * Класс описывающий пользователя
     */
    public static class User {
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        /**
         * Идентификатор
         */
        int id;
        /**
         * Имя пользователя
         */
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * Класс описывающий информацию о состоянии списка
     */
    public static class Info {
        /**
         * Колличество добавленных
         */
        int added;
        /**
         * Количество измененых
         */
        int changed;
        /**
         * Количество удаленных
         */
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }

}
