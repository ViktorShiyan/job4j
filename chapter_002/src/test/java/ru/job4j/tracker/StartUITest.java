package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

/**
 * Тест для проверки работы пользовательского интерфейса
 *
 * @author Viktor Shiayn
 * @since 25.12.2018
 */
public class StartUITest {
    private Tracker tracker = new Tracker();
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
     * Тест на добавление заявки
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Тест на изменения заявки
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Тест на удаление заявки
     */
    @Test
    public void whenDeliteItem() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    /**
     * Тест вывод всех заявок
     */
    @Test
    public void whenShowAll() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()).contains(item.getId()), is(true));
    }

    /**
     * Тест вывод заявки по ID
     */
    @Test
    public void whenShowById() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()).contains(item.getName()), is(true));
    }

    /**
     * Тест вывод заявок по названию
     */
    @Test
    public void whenShowByName() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()).contains(item.getName()), is(true));
    }

    /**
     * Тест вывод заявок по названию
     * Когда заявок с одним название больше одной
     */
    @Test
    public void whenMoreShowByName() {
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name", "desc number two"));
        Item item3 = tracker.add(new Item("test name", "desc number three"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        boolean contains = new String(out.toByteArray()).contains(item.getDesc());
        boolean contains1 = new String(out.toByteArray()).contains(item2.getDesc());
        boolean contains2 = new String(out.toByteArray()).contains(item3.getDesc());
        assertThat(contains && contains1 && contains2, is(true));
    }
}