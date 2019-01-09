package ru.job4j.bank;

/**
 * Класс описывающий пользователя
 *
 * @author Viktor Shiyan
 * @since 09.01.2019
 */
public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj == this) {
            result = true;
        }
        if (obj != null && this.getClass().equals(obj.getClass())) {
            User userCompare = (User) obj;
            if (this.getName().equals(userCompare.name) && this.getPassport().equals(userCompare.getPassport())) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
