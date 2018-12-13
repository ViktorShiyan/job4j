package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Board
 *
 * @author Viktor Shiayn
 * @since 13.12.2018
 */
public class BoardTest {

    /**
     * Тест для доски 3 на 3
     */
    @Test
    public void when3x3() {
        Board board = new Board();
        String rsl = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X%s X %sX X%s", ln, ln, ln)
                )
        );
    }

    /**
     * Тест для доски 5 на 5
     */
    @Test
    public void when5x5() {
        Board board = new Board();
        String rsl = board.paint(5, 5);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X X%s X X %sX X X%s X X %sX X X%s", ln, ln, ln, ln, ln)
                )
        );
    }
}