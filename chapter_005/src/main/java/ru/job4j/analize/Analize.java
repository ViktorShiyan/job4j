package ru.job4j.analize;

import java.util.ArrayList;
import java.util.List;

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
        List<User> listTemp = new ArrayList<>(current);
        int notChanged = 0;
        Info info = new Info(0, 0, 0);
        for (User userPrev : previous) {
            for (int i = 0; i < listTemp.size(); i++) {
                if (userPrev.id == listTemp.get(i).id && userPrev.name.equals(listTemp.get(i).name)) {
                    listTemp.remove(i);
                    notChanged++;
                    break;
                } else if (userPrev.id == listTemp.get(i).id) {
                    info.changed++;
                    listTemp.remove(i);
                    break;
                }
            }
        }
        info.added = listTemp.size();
        info.deleted = previous.size() - (notChanged + info.changed);
        return info;
    }

    /**
     * Класс описывающий пользователя
     */
    public static class User {
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
