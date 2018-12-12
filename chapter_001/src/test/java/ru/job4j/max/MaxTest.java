package ru.job4j.max;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест для класса Max
 */
public class MaxTest {
    private Max max;

    @Before
    public void setUp() throws Exception {
        max = new Max();
    }

    /**
     * Тест когда первое число меньше
     */
    @Test
    public void whenFirstLessSecond() {
        int result = max.maxOfTwo(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Тест когда второе число меньше
     */
    @Test
    public void whenSecondLessFirst() {
        int result = max.maxOfTwo(2, 1);
        assertThat(result, is(2));
    }

    /**
     * Тест когда числа ровны
     */
    @Test
    public void whenSmooth() {
        int result = max.maxOfTwo(2, 2);
        assertThat(result, is(2));
    }
}