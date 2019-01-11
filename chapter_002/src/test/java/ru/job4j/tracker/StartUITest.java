package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

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
    private final Tracker tracker = new Tracker();
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };


    /**
     * Тест на добавление заявки
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    /**
     * Тест на изменения заявки
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Тест на удаление заявки
     */
    @Test
    public void whenDeliteItem() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    /**
     * Тест вывод всех заявок
     */
    @Test
    public void whenShowAll() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(out.toByteArray()).contains(item.getId()), is(true));
    }

    /**
     * Тест вывод заявки по ID
     */
    @Test
    public void whenShowById() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(out.toByteArray()).contains(item.getName()), is(true));
    }

    /**
     * Тест вывод заявок по названию
     */
    @Test
    public void whenShowByName() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "y"});
        new StartUI(input, tracker, output).init();
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
        Input input = new StubInput(new String[]{"5", item.getName(), "y"});
        new StartUI(input, tracker, output).init();
        boolean contains = new String(out.toByteArray()).contains(item.getDesc());
        boolean contains1 = new String(out.toByteArray()).contains(item2.getDesc());
        boolean contains2 = new String(out.toByteArray()).contains(item3.getDesc());
        assertThat(contains && contains1 && contains2, is(true));
    }
}