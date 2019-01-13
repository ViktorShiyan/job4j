package ru.job4j.student;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Viktor Shiyan
 * @since 13.01.2019
 */
public class StudentSorterTest {
    private List<Student> students;
    private StudentSorter studentSorter = new StudentSorter();

    @Before
    public void setUp() {
        students = List.of(
                new Student("Ivan", 5),
                new Student("Viktor", 4),
                new Student("Jhon", 3),
                new Student("Jak", 2),
                new Student("Michail", 3),
                new Student("Semen", 4),
                new Student("Aleksandr", 5)
        );

    }

    @Test
    public void whenLevelOf5() {
        List<Student> result = studentSorter.levelOf(this.students, 5);
        int expect = 2;
        assertThat(expect, is(result.size()));
    }

    @Test
    public void whenLevelOf4() {
        List<Student> result = studentSorter.levelOf(this.students, 4);
        int expect = 4;
        assertThat(expect, is(result.size()));
    }

    @Test
    public void whenLevelOf3() {
        List<Student> result = studentSorter.levelOf(this.students, 3);
        int expect = 6;
        assertThat(expect, is(result.size()));
    }

    @Test
    public void whenLevelOf2() {
        List<Student> result = studentSorter.levelOf(this.students, 2);
        int expect = 7;
        assertThat(expect, is(result.size()));
    }
}