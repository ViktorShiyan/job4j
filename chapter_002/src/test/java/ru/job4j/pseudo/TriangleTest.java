package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест класса Triangle
 *
 * @author Viktor Shiyan
 * 25.12.2018
 */
public class TriangleTest {

    /**
     * Тест на отрисовку триугольника
     */
    @Test
    public void drew() {
        Triangle triangle = new Triangle();
        String result = triangle.drew();
        String expect = new StringBuilder().append("  *  ").append(" *** ").append("*****").toString();
        assertThat(result, is(expect));
    }
}