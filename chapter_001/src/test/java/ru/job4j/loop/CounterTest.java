package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест для класса Counter
 *
 * @author Viktor Shiayn
 * @since 13.12.2018
 */
public class CounterTest {

    /**
     * Тест метода add
     */
    @Test
    public void add() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        int expect = 30;
        assertThat(result, is(expect));
    }
}