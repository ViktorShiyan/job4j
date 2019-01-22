package ru.job4j.map;

import java.util.Calendar;

/**
 * Класс описывающий пользователя
 *
 * @author Viktor Shiyan
 * @since 22.01.2019
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public Calendar getBirthday() {
        return birthday;
    }
}
