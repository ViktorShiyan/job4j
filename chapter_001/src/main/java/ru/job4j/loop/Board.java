package ru.job4j.loop;

/**
 * Класс реализующий шахматную доску разных размеров
 *
 * @author Viktor Shiyan
 * @since 13.12.2018
 */
public class Board {
    /**
     * Метод рисующий шахматную доску заданного размера
     *
     * @param width  ширина
     * @param height высота
     * @return строку с шахматной доской
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == 0 && j == 0) || (i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}

