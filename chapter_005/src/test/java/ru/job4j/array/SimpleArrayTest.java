package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Viktor Shiyan
 * @since 15.01.2019
 */
public class SimpleArrayTest {
    SimpleArray<String> stringSimpleArray;

    @Before
    public void setUp() {
        stringSimpleArray = new SimpleArray<String>(4);
        stringSimpleArray.add("1");
        stringSimpleArray.add("2");
        stringSimpleArray.add("3");
    }

    @Test
    public void whenStringAdd() {
        assertThat(stringSimpleArray.get(2), is("3"));

    }

    @Test
    public void whenStringAddException() {
        stringSimpleArray.add("4");
        String res = "";
        try {
            stringSimpleArray.add("5");
        } catch (RuntimeException re) {
            res = re.getMessage();
        }
        assertThat(res, is("Переполнение"));
    }

    @Test
    public void whenIntegerAddException() {
        SimpleArray<Integer> stringSimpleArray = new SimpleArray<Integer>(4);
        stringSimpleArray.add(1);
        stringSimpleArray.add(2);
        stringSimpleArray.add(3);
        stringSimpleArray.add(4);
        String res = "";
        try {
            stringSimpleArray.add(5);
        } catch (RuntimeException re) {
            res = re.getMessage();
        }
        assertThat(res, is("Переполнение"));
    }

    @Test
    public void whenIntegerAdd() {
        SimpleArray<Integer> stringSimpleArray = new SimpleArray<Integer>(4);
        stringSimpleArray.add(1);
        stringSimpleArray.add(2);
        stringSimpleArray.add(3);
        assertThat(stringSimpleArray.get(2), is(3));

    }

    @Test
    public void whenIntegerDel() {
        SimpleArray<Integer> stringSimpleArray = new SimpleArray<Integer>(4);
        stringSimpleArray.add(1);
        stringSimpleArray.add(2);
        stringSimpleArray.add(3);
        stringSimpleArray.add(4);
        stringSimpleArray.remove(2);
        assertThat(stringSimpleArray.get(2), is(4));

    }

    @Test
    public void whenStringDel() {
        stringSimpleArray.add("4");
        stringSimpleArray.remove(2);
        assertThat(stringSimpleArray.get(2), is("4"));

    }

    @Test
    public void whenStringSet() {
        stringSimpleArray.add("4");
        stringSimpleArray.set(1, "replace");
        assertThat(stringSimpleArray.get(1), is("replace"));

    }

    @Test
    public void whenStringIterator() {
        Iterator it = stringSimpleArray.iterator();
        it.next();
        it.next();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("3"));

    }

    @Test
    public void whenStringIteratorException() {
        Iterator it = stringSimpleArray.iterator();
        it.next();
        it.next();
        it.next();
        String res = "";
        try {
            it.next();
        } catch (NoSuchElementException re) {
            res = re.getMessage();
        }
        assertThat(res, is("No"));
    }
}