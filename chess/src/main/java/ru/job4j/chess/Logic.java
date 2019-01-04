package ru.job4j.chess;

import ru.job4j.chess.exeptions.FigureNotFoundException;
import ru.job4j.chess.exeptions.ImpossibleMoveException;
import ru.job4j.chess.exeptions.OccupiedWayException;
import ru.job4j.chess.figures.*;

import java.util.Arrays;
import java.util.List;

/**
 * Класс описывающий логику
 *
 * @author Viktor Shiyan
 * @since 04.01.2019
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws OccupiedWayException,
            ImpossibleMoveException,
            FigureNotFoundException {

        boolean rst = false;
        int index = this.findBy(source);
        try {
            figureAbsent(index);
            Cell[] steps = this.figures[index].way(source, dest);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rst = true;
            }
            occupiedWay(source, dest, index);
            this.figures[index] = this.figures[index].copy(dest);

        } catch (FigureNotFoundException fnfe) {
            rst = false;
            System.out.println("Фигура не найдена!");
        } catch (ImpossibleMoveException ime) {
            rst = false;
            System.out.println("Нарушение логики хода фигуры!");
        } catch (OccupiedWayException owe) {
            rst = false;
            System.out.println("Путь занят!");
        }
        return rst;
    }

    private void figureAbsent(int index) {
        if (index == -1) {
            throw new FigureNotFoundException("Фигура не найдена!");
        }
    }

    private void occupiedWay(Cell source, Cell dest, int index) {
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            Arrays.stream(this.figures)
                    .forEach(otherFigure -> {
                        if (Arrays.stream(steps)
                                .anyMatch(step -> otherFigure != null && step.equals(otherFigure.position())
                                )
                        ) {
                            throw new OccupiedWayException("Путь занят!");
                        }
                    });
        }
    }

    public void clean() {
        Arrays.stream(this.figures)
                .forEach(figure -> figure = null);
        this.index = 0;
    }

    private int findBy(Cell cell) {
        final int[] rst = {-1};
        List<Figure> figuresList = Arrays.asList(this.figures);
        figuresList.stream()
                .forEach(figure -> {
                    if (figure != null && figure.position().equals(cell)) {
                        rst[0] = figuresList.indexOf(figure);
                    }
                });
        return rst[0];
    }
}