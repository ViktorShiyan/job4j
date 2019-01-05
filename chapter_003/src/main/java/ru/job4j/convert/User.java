package ru.job4j.convert;

/**
 * Класс описывающий пользователя
 *
 * @author Viktor Shiyan
 * @since 05.01.2018
 */
public class User {
    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
}
