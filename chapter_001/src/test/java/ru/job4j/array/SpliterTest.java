package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест класса Spliter
 *
 * @author Viktor Shiayn
 * @since 19.12.2018
 */
public class SpliterTest {

    /**
     * Первый тест на равность массивов
     */
    @Test
    public void splitEqualy() {
        int[] testArrey = {2, 2, 2, 2};
        Spliter spliter = new Spliter();
        int[][] result = spliter.splitEqualy(testArrey);
        assertThat(result[0][0], is(result[1][0]));
    }

    /**
     * Второй тест на равность массивов
     */
    @Test
    public void splitEqualyTwo() {
        int[] testArrey = {1, 2, 7, 10};
        Spliter spliter = new Spliter();
        int[][] result = spliter.splitEqualy(testArrey);
        assertThat(spliter.sum(result[0], 0, result[0].length - 1),
                is(spliter.sum(result[1], 0, result[1].length - 1)));
    }

    /**
     * Третий тест на равность массивов
     */
    @Test
    public void splitEqualyThree() {
        int[] testArrey = {45, 1, 2, 7, 10};
        Spliter spliter = new Spliter();
        int[][] result = spliter.splitEqualy(testArrey);
        assertThat(result[0], is(new int[]{1, 2, 7, 10}));
    }

    /**
     * Тест метода сумирования среза
     */
    @Test
    public void sum() {
        int[] testArrey = {1, 1, 1, 1, 1};
        Spliter spliter = new Spliter();
        int result = spliter.sum(testArrey, 2, 4);
        int expect = 3;
        assertThat(result, is(expect));
    }
}