package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест для класса Factorial
 *
 * @author Viktor Shiayn
 * @since 13.12.2018
 */
public class FactorialTest {

    /**
     * Тест факториал от числа 5
     */
    @Test
    public void calcFive() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        int expect = 120;
        assertThat(result, is(expect));
    }

    /**
     * Тест факториал от числа 0
     */
    @Test
    public void calcZero() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        int expect = 1;
        assertThat(result, is(expect));
    }
}