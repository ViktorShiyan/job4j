package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

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


    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    @Test
    public void createItem() throws SQLException {
        TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()));
        tracker.add(new Item("name", "desc"));
        assertThat(tracker.findByName("name").size(), is(1));
    }

    /**
     * метод заполняет трекер заявками
     */
    @Before
    public void setUp() throws SQLException {
        sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        itemOne = new Item("test1", "testDescription");
        sql.add(itemOne);
        Item itemTwo = new Item("test2", "testDescription2");
        sql.add(itemTwo);
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