package ru.job4j.chess.exeptions;


/**
 * Ошибка невозможности хода
 *
 * @author Viktor Shiayn
 * @since 04.01.2019
 */
public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
