package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Класс описывающий пользователя
 *
 * @author Viktor Shiyan
 * @since 22.01.2019
 */
public class User {
    private int hashCode;
    private String name;
    private int children;
    private Calendar birthday;

    public static void main(String[] args) {
        User userOne = new User("Viktor", 1, new GregorianCalendar(1991, 3, 2));
        User userTwo = new User("Viktor", 1, new GregorianCalendar(1991, 3, 2));
        HashMap<User, String> hashMap = new HashMap<>();
        hashMap.put(userOne, "First");
        hashMap.put(userTwo, "Second");
        System.out.println(hashMap);
    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User uComp = (User) obj;
        return uComp.name.equals(this.name) && uComp.children == this.children && uComp.birthday.equals(this.birthday);

    }

    @Override
    public int hashCode() {
        int result = this.hashCode;
        if (result == 0) {
            result = 31 * result + this.birthday.hashCode();
            result = 31 * result + this.name.hashCode();
            result = 31 * result + this.children;
        }
        return result;
    }
}
