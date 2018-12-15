package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест класса строящего таблицу умножения
 *
 * @author Viktor Shiyan
 * @since 15.12.2018
 */
public class MatrixTest {

    /**
     * Тест метода строящего таблицу умножения
     */
    @Test
    public void multiple() {
        Matrix matrix = new Matrix();
        int[][] result = matrix.multiple(3);
        int[][] expect = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertThat(result, is(expect));
    }
}