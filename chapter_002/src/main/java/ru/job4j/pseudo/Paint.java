package ru.job4j.pseudo;

/**
 * @author Viktor Shiyan
 * @since 25.12.2018
 */
public class Paint {
    /**
     * Метод отрисовывает фигуру класса реализовавшего интерфейс Shape
     *
     * @param shape Экземпляр класса реализовавшего интерфейс Shape
     */
    public void drew(Shape shape) {
        System.out.println(shape.drew());
    }
}