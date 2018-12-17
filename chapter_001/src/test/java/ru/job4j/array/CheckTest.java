package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест класса Check
 *
 * @author Viktor Shiayn
 * @since 15.12.2018
 */
public class CheckTest {
    Check testChek;

    @Before
    public void setUp() {
        testChek = new Check();
    }

    /**
     * Тест когда все значения false и массив четный
     */
    @Test
    public void whenEvenFalse() {
        boolean[] data = new boolean[]{false, false, false};
        boolean result = testChek.mono(data);
        assertThat(result, is(true));
    }

    /**
     * Тест когда все значения false и массив не четный
     */
    @Test
    public void whenNotEvenFalse() {
        boolean[] data = new boolean[]{false, false};
        boolean result = testChek.mono(data);
        assertThat(result, is(true));
    }

    /**
     * Тест когда все значения true и массив четный
     */
    @Test
    public void whenEvenTrue() {
        boolean[] data = new boolean[]{true, true, true};
        boolean result = testChek.mono(data);
        assertThat(result, is(true));
    }

    /**
     * Тест когда все значения true и массив не четный
     */
    @Test
    public void whenNotEvenTrue() {
        boolean[] data = new boolean[]{true, true};
        boolean result = testChek.mono(data);
        assertThat(result, is(true));
    }

    /**
     * Тест когда одно значение
     */
    @Test
    public void whenNotEvenTrueOne() {
        boolean[] data = new boolean[]{true};
        boolean result = testChek.mono(data);
        assertThat(result, is(true));
    }

    /**
     * Тест когда все значения разные
     */
    @Test
    public void whenFalse() {
        boolean[] data = new boolean[]{true, false, true};
        boolean result = testChek.mono(data);
        assertThat(result, is(false));
    }
}