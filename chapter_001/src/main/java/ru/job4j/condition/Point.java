package ru.job4j.condition;

/**
 * Class describing the point
 *
 * @author Viktor Shiyan
 * @since 12.12.2018
 */
public class Point {
    private int x;
    private int y;

    /**
     * Class constructor
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method finding distance point to point
     *
     * @param that second point
     * @return distance point to point
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
    }
}
