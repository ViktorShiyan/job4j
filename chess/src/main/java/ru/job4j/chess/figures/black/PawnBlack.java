package ru.job4j.chess.figures.black;

import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;


/**
 * @author Viktor Shiyan
 * @since 04.01.2019
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps;
        if (source.y == dest.y + 1 && source.x == dest.x) {
            steps = new Cell[]{dest};
        } else {
            throw new ImpossibleMoveException("Нарушение логики хода фигуры");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}