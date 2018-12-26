package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест валидного ввода
 *
 * @author ViktorShiyan
 * @version 26.12.2018
 */
public class ValidInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    private String newLine = System.lineSeparator();

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Тест на ввод не цифры
     */
    @Test
    public void whenInvalidInput() {
        ValidInput input = new ValidInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        input.ask("Enter", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Введите коректные данные%s", newLine)
                )
        );
    }

    /**
     * Тест на ввод цыфры превышающей диапозон
     */
    @Test
    public void whenUnrangeInput() {
        ValidInput input = new ValidInput(
                new StubInput(new String[]{"6", "1"})
        );
        input.ask("Enter", new int[]{0, 1, 2, 3, 4, 5});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Введите пункт не выходящий из диапозона.%s", newLine)
                )
        );
    }
}
