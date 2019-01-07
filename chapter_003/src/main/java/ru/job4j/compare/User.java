package ru.job4j.compare;

/**
 * Класс описывающий пользователя
 *
 * @author Viktor Shiyan
 * @since 07.01.2019
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    /**
     * Конструктор
     *
     * @param name имя пользователя
     * @param age  возраст пользователя
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * @return имя пользователя
     */
    public String getName() {
        return name;
    }

    /**
     * @return возраст пользователя
     */
    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        return this.age > o.age ? 1 : -1;
    }
}
