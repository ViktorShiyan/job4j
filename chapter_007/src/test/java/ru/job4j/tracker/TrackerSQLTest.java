package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * тест на класс SQLTracker
 *
 * @author viktorshiyan
 * @since 14.03.2019
 */
public class TrackerSQLTest {

    private TrackerSQL sql;
    private Item itemOne;

    /**
     * метод заполняет трекер заявками
     */
    @Before
    public void setUp() {
        sql = new TrackerSQL();
        itemOne = new Item("test1", "testDescription");
        sql.add(itemOne);
        Item itemTwo = new Item("test2", "testDescription2");
        sql.add(itemTwo);
    }

    /**
     * Метод очищает таблицу
     */
    @After
    public void tearDown() {
        TrackerSQL sql = new TrackerSQL();
        sql.dropTable();
    }

    /**
     * Тест на добавление заявок
     */
    @Test
    public void add() {
        Item result = sql.findByName("test1").get(0);
        assertThat(result.getName(), is(itemOne.getName()));
    }

    /**
     * Тест на получение всех заявок
     */
    @Test
    public void findAll() {
        List<Item> itemList = sql.findAll();
        assertThat(itemList.size(), is(2));
    }

    /**
     * Тест на удаление заявки из базы
     */
    @Test
    public void delete() {
        List<Item> itemList = sql.findAll();
        Item deleteItem = itemList.get(0);
        sql.delete(deleteItem.getId());
        itemList = sql.findAll();
        assertThat(itemList.size(), is(1));
    }

    /**
     * Тест на замену заявки
     */
    @Test
    public void replace() {
        Item itemTest = sql.findByName("test1").get(0);
        sql.replace(itemTest.getId(), new Item("replace", "replace description"));
        Item itemResult = sql.findByName("replace").get(0);
        assertThat(itemTest.getId(), is(itemResult.getId()));
    }

    /**
     * Тест на поиск заявки по id
     */
    @Test
    public void findById() {
        Item itemTest = sql.findByName("test1").get(0);
        Item itemResult = sql.findById(itemTest.getId());
        assertThat(itemResult.getName(), is(itemTest.getName()));
    }

    /**
     * тест на поиск заявки по имени
     */
    @Test
    public void findByName() {
        Item result = sql.findByName("test1").get(0);
        assertThat(result.getName(), is("test1"));
    }
}