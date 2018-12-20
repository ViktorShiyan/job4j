package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест класса Tracker
 *
 * @author Viktor Shiayn
 * @since 21.12.2018
 */
public class TrackerTest {
    /**
     * Тест проверяющий метод добавления заявки
     */
    @Test
    public void add() {
        Tracker storing = new Tracker();
        Item expect = new Item("FIRST", "FIRST ITEM");
        Item result = storing.add(expect);
        assertThat(result, is(expect));
    }

    /**
     * Тест метода возвращающего заявку по id
     */
    @Test
    public void findById() {
        Tracker storing = new Tracker();
        Item test = new Item("test", "testing function");
        storing.add(test);
        Item expect = storing.findById(test.getId());
        assertThat(test, is(expect));
    }

    /**
     * Тест метода возрашающего массив заявок без null
     */
    @Test
    public void findAll() {
        Tracker storing = new Tracker();
        Item one = new Item("test1", "description1");
        storing.add(one);
        Item two = new Item("test2", "description2");
        storing.add(two);
        Item three = new Item("test3", "description3");
        storing.add(three);
        Item four = new Item("test3", "description3");
        storing.add(four);
        Item[] result = storing.findAll();
        Item[] expect = {one, two, three, four};
        assertThat(result, is(expect));
    }

    /**
     * Тест проверки вызова массива заявок по имени
     */
    @Test
    public void findByName() {
        Tracker storing = new Tracker();
        storing.add(new Item("first", "tra taaaa"));
        storing.add(new Item("second", "diiddidididd"));
        storing.add(new Item("first", "rrrrrrrr"));
        Item[] result = storing.findByName("first");
        Item first = storing.findById(result[0].getId());
        Item second = storing.findById(result[1].getId());
        Item[] expect = {first, second};
        assertThat(result, is(expect));
    }

    /**
     * Тест метода удаляющего заявку
     */
    @Test
    public void delete() {
        Tracker storing = new Tracker();
        Item one = new Item("test1", "description1");
        storing.add(one);
        Item two = new Item("test2", "description2");
        storing.add(two);
        Item three = new Item("test3", "description3");
        storing.add(three);
        Item four = new Item("test4", "description4");
        storing.add(four);
        Item[] expect = {one, two, four};
        storing.delete(three.getId());
        Item[] result = storing.findAll();
        assertThat(result, is(expect));
    }

    /**
     * Тест метода который заменяет заявку по id
     */
    @Test
    public void replace() {
        Tracker storing = new Tracker();
        Item test = new Item("TEST", "TESTING");
        storing.add(test);
        Item replaceable = new Item("Replace", "ЗАМЕНЯЕМ");
        storing.replace(test.getId(), replaceable);
        assertThat(storing.findById(replaceable.getId()), is(replaceable));
    }
}