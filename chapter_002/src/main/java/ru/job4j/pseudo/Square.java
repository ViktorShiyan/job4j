package ru.job4j.pseudo;

/**
 * Класс реализует интерфейс Shape
 * рисует квадрат
 *
 * @author Viktor Shiyan
 * @since 25.12.2018
 */
public class Square implements Shape {
    /**
     * Реализованный метод рисования
     *
     * @return строку с псевдоквадратом
     */
    @Override
    public String drew() {
        StringBuilder squere = new StringBuilder();
        squere.append("****");
        squere.append("****");
        squere.append("****");
        squere.append("****");
        return squere.toString();
    }
}
