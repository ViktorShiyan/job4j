package ru.job4j.chess.exeptions;

/**
 * Ошибка отсутствия фигуры
 *
 * @author Viktor Shiayn
 * @since 04.01.2019
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
