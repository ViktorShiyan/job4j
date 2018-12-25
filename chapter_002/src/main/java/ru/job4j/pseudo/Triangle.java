package ru.job4j.pseudo;

/**
 * Класс реализует интерфейс Share
 *
 * @author Viktor Shiyan
 * @version 1.0
 * @since 09.02.2018
 */
public class Triangle implements Shape {
    /**
     * Метод формирующий треугольник
     *
     * @return строку с треугольником
     */
    @Override
    public String drew() {
        StringBuilder triangle = new StringBuilder();
        triangle.append("  *  ");
        triangle.append(" *** ");
        triangle.append("*****");
        return triangle.toString();
    }
}
