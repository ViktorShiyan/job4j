package ru.job4j.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест класса UserSort
 *
 * @author ViktorShiayn
 * @since 07.01.2019
 */
public class UserSortTest {

    @Test
    public void whenLittleMike() {
        UserSort userSort = new UserSort();
        List<User> userList = List.of(
                new User("Jhon", 100),
                new User("Mike", 10),
                new User("Viktor", 27)
        );
        Set<User> userSet = userSort.sort(userList);
        Iterator<User> iterator = userSet.iterator();
        assertThat(iterator.next(), is(userList.get(1)));
    }

    @Test
    public void whenLittleViktor() {
        UserSort userSort = new UserSort();
        List<User> userList = List.of(
                new User("Jhon", 100),
                new User("Mike", 100),
                new User("Viktor", 27)
        );
        Set<User> userSet = userSort.sort(userList);
        Iterator<User> iterator = userSet.iterator();
        assertThat(iterator.next(), is(userList.get(2)));
    }

    @Test
    public void whenViktorLong() {
        UserSort userSort = new UserSort();
        List<User> userList = List.of(
                new User("Jhon", 100),
                new User("Mike", 100),
                new User("Viktor", 27)
        );
        userList = userSort.sortNameLength(userList);
        assertThat(userList.get(2).getName(), is("Viktor"));
    }

    @Test
    public void whenIvan() {
        UserSort userSort = new UserSort();
        List<User> userList = List.of(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        );
        List<User> result = userSort.sortByAllFields(userList);
        Iterator<User> iterator = result.iterator();
        assertThat(iterator.next().getName(), is("Иван"));
        assertThat(iterator.next().getName(), is("Иван"));
    }
}