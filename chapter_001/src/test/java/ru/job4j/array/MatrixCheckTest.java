package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса MatrixCheck
 *
 * @author Viktor Shiayn
 * @since 15.12.2018
 */
public class MatrixCheckTest {
    /**
     * Диагонали одинаковы размер 3 на 3
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Диагонали не одинаковы размер 3 на 3
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Диагонали одинаковы размер 5 на 5
     */
    @Test
    public void whenDataMonoByTrueThenTrue5X5() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true, true, true},
                {false, true, true, true, true},
                {true, false, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Диагонали не одинаковы размер 5 на 5
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse5X5() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, false},
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Диагонали одинаковы размер 2 на 2
     */
    @Test
    public void whenDataMonoByTrueThenTrue2X2() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false},
                {false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Диагонали не одинаковы размер 2 на 2
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse2X2() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true},
                {false, false}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Диагонали одинаковы размер 4 на 4
     */
    @Test
    public void whenDataMonoByTrueThenTrue4X4() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false, true, false},
                {false, true, false, true},
                {false, false, true, false},
                {false, false, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Диагонали не одинаковы размер 4 на 4
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse4X4() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false, true, true},
                {false, true, false, true},
                {false, false, true, false},
                {false, false, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}
