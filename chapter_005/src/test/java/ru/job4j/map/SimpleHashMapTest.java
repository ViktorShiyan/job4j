package ru.job4j.map;

import org.junit.Test;


import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

/**
 * @author Viktor Shiyan
 * @since 23.01.2019
 */
public class SimpleHashMapTest {
    @Test
    public void whenAdd() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, "First");
        assertThat(simpleHashMap.get(1), is("First"));
        simpleHashMap.insert(1, "FirstTwo");
        simpleHashMap.insert(63456, "FirstTwo");
        simpleHashMap.insert(63456, "FirstTwo");
        simpleHashMap.insert(null, "Null");
        simpleHashMap.insert(null, "NullTwo");
        assertThat(simpleHashMap.get(1), is("FirstTwo"));
        assertThat(simpleHashMap.get(63456), is("FirstTwo"));
        assertThat(simpleHashMap.get(null), is("NullTwo"));
    }

    @Test
    public void whenDelete() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, "First");
        simpleHashMap.insert(null, "Null");
        assertThat(simpleHashMap.delete(1), is(true));
        assertThat(simpleHashMap.get(1), is(nullValue()));
        assertThat(simpleHashMap.delete(null), is(true));
        assertThat(simpleHashMap.get(null), is(nullValue()));
    }

    @Test
    public void whenIterator() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, "One");
        simpleHashMap.insert(2, "Two");
        simpleHashMap.insert(3, "Tree");
        Iterator it = simpleHashMap.iterator();
        SimpleHashMap.Entry a = (SimpleHashMap.Entry) it.next();
        assertThat(a.getValue(), is("One"));
        a = (SimpleHashMap.Entry) it.next();
        assertThat(a.getValue(), is("Two"));
        a = (SimpleHashMap.Entry) it.next();
        assertThat(a.getValue(), is("Tree"));
    }
}