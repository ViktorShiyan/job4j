package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест Stream
 *
 * @author Viktor Shiyan
 * @since 12.01.2019
 */
public class StreamUsageTest {

    private StreamUsage.Task task1;
    private StreamUsage.Task task2;
    private StreamUsage.Task task3;

    @Before
    public void setUp() {
        task1 = new StreamUsage.Task("Bug #1", 100);
        task2 = new StreamUsage.Task("Task #2", 100);
        task3 = new StreamUsage.Task("Bug #3", 100);
    }

    @Test
    public void filterBug() {
        List<StreamUsage.Task> tasks = List.of(
                task1,
                task2,
                task3
        );
        List<StreamUsage.Task> expect = List.of(task1, task3);
        List<StreamUsage.Task> bugs = tasks.stream().filter(
                task -> task.getName().contains("Bug")
        ).collect(Collectors.toList());
        assertThat(bugs, is(expect));
    }

    @Test
    public void covertName() {
        List<StreamUsage.Task> tasks = List.of(
                task1,
                task2,
                task3
        );
        List<String> expect = List.of(task1.getName(), task2.getName(), task3.getName());
        List<String> result = tasks.stream().map(StreamUsage.Task::getName).collect(Collectors.toList());
        assertThat(result,is(expect));
    }
}