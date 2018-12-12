package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Test for class Point
 */
public class PointTest {

    /**
     * Test distance point to point
     */
    @Test
    public void distanceTo() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 4);
        double expect = 2D;
        double result = point1.distanceTo(point2);
        assertThat(expect, closeTo(result, 0.1));
    }
}