package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест класса FindLoop
 *
 * @author Viktor Shiayn
 * @since 14.12.2018
 */
public class FindLoopTest {
    private FindLoop find;
    private int[] input;

    @Before
    public void setUp() {
        find = new FindLoop();
        input = new int[]{5, 10, 3};
    }

    /**
     * Тест элемент найден
     */
    @Test
    public void whenArrayHasLengh5Then0() {
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Тест элемент не найден
     */
    @Test
    public void whenArrayNotHaveElement() {
        int value = 13;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}