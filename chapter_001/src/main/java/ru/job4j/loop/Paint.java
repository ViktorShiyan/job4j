package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Класс отрисовывающий пирамидку
 *
 * @author Viktor Shiayn
 * @since 14.12.2018
 */
public class Paint {
    /**
     * Метод для отрисовки правой стороны треугольника
     *
     * @param height высота
     * @return строку с правой стороной треугольника
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Метод для отрисовки левой стороны треугольника
     *
     * @param height высота
     * @return строку с левой стороной треугольника
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Метод для отрисовки пирамиды
     *
     * @param height высота
     * @return строку с пирамидой
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Универсальный метод отрисовки
     *
     * @param height  высота
     * @param weight  ширина
     * @param predict условие проставление галки
     * @return строку с отрисовонной фигурой
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
