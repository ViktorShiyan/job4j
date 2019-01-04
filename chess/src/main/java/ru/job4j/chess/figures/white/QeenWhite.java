package ru.job4j.chess.figures.white;

import ru.job4j.chess.Moving;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;


/**
 * @author Viktor Shiyan
 * @since 04.01.2019
 */
public class QeenWhite implements Figure, Moving {
    private final Cell position;

    public QeenWhite(final Cell position) {
        this.position = position;
    }


    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        boolean wrongMove = !(Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y))
                && !(Math.abs(source.y - dest.y) == 0 || (Math.abs(source.x - dest.x) == 0));
        int sizeSteps = Math.abs(source.y - dest.y) == Math.abs(source.x - dest.x)
                ? Math.abs(source.x - dest.x) : Math.abs(source.x - dest.x) + Math.abs(source.y - dest.y);
        return Moving.commonPart(source, dest, wrongMove, sizeSteps);
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenWhite(dest);
    }
}