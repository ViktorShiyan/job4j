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
        List<User> userList = new ArrayList<>();
        userList.add(new User("Jhon", 100));
        userList.add(new User("Mike", 10));
        userList.add(new User("Viktor", 27));
        Set<User> userSet = userSort.sort(userList);
        Iterator<User> iterator = userSet.iterator();
        assertThat(iterator.next(), is(userList.get(1)));
    }

    @Test
    public void whenLittleViktor() {
        UserSort userSort = new UserSort();
        List<User> userList = new ArrayList<>();
        userList.add(new User("Jhon", 100));
        userList.add(new User("Mike", 100));
        userList.add(new User("Viktor", 27));
        Set<User> userSet = userSort.sort(userList);
        Iterator<User> iterator = userSet.iterator();
        assertThat(iterator.next(), is(userList.get(2)));
    }
}