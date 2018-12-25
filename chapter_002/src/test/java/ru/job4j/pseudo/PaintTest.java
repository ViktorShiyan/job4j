package ru.job4j.pseudo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест класса Paint
 *
 * @author Viktor Shiayn
 * @since 25.12.2018
 */
public class PaintTest {

    /**
     * Тест на отрисовку треугольника
     */
    @Test
    public void drewTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().drew(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("  *  ")
                                .append(" *** ")
                                .append("*****")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        System.setOut(stdout);
    }

    /**
     * Тест на отрисовку квадрата
     */
    @Test
    public void drewSquere() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().drew(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("****")
                                .append("****")
                                .append("****")
                                .append("****")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        System.setOut(stdout);

    }
}