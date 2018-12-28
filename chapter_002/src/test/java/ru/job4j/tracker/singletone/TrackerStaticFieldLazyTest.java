package ru.job4j.tracker.singletone;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест на проверку синглетоности
 *
 * @author Viktor Shiyan
 * @since 28.12.2018
 */
public class TrackerStaticFieldLazyTest {
    @Test
    public void whenClassSingletone() {
        TrackerStaticFieldLazy tracker = TrackerStaticFieldLazy.getInstance();
        tracker.add(new Item("test", "descTest"));
        TrackerStaticFieldLazy trackerTwin = TrackerStaticFieldLazy.getInstance();
        tracker.add(new Item("test2", "descTest"));
        assertThat(trackerTwin.findAll(), is(tracker.findAll()));
    }

}