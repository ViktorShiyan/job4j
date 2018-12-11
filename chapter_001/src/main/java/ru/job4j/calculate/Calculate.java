package ru.job4j.calculate;

/**
 * Класс служит для вывода приветствия
 *
 * @author Viktor Shiyan
 * @since 11.12.2018
 */
public class Calculate {
    /**
     * Главный метод
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    /**
     * Method echo.
     *
     * @param name Your name.
     * @return Echo plus your name.
     */
    String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}
