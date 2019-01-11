package ru.job4j.lyambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Класс преобразующий имена в пользователей
 *
 * @author ViktorShiayn
 * @since 11.01.2019
 */
public class UserConvert {
    /**
     * Класс описывающий пользователя
     */
    public static class User {
        private final String name;


        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" + "name='" + name + '\'' + '}';
        }
    }

    /**
     * Метод преобразуюющий имена в пользователей
     *
     * @param names имена
     * @param op    операция
     * @return список пользователей
     */
    public List<User> convert(List<String> names, Function<String, User> op) {
        List<User> users = new ArrayList<>();
        names.forEach(
                n -> users.add(op.apply(n))
        );
        return users;
    }
}
