package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
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
    private PrintStream stdout = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Переопределяется вывод в память
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Возвращает стандартный вывод
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Тест на отрисовку треугольника
     */
    @Test
    public void drewTriangle() {
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
    }

    /**
     * Тест на отрисовку квадрата
     */
    @Test
    public void drewSquere() {
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

    }
}