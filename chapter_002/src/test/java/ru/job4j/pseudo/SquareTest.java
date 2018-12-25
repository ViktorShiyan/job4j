package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест класса Squere
 *
 * @author Viktor Shiyan
 * 25.12.2018
 */
public class SquareTest {

    /**
     * Тест на отрисовку Квадрата
     */
    @Test
    public void drew() {
        Square square = new Square();
        String result = square.drew();
        String expect = new StringBuilder().append("****").append("****").append("****").append("****").toString();
        assertThat(result, is(expect));
    }

}