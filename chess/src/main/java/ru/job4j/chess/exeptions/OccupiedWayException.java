package ru.job4j.chess.exeptions;

/**
 * Ошибка занятой клетки
 *
 * @author Viktor Shiayn
 * @since 04.01.2019
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
