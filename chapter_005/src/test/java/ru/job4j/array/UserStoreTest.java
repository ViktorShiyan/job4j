package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    private UserStore userStore;

    @Before
    public void setUp() {
        userStore = new UserStore(5);
        userStore.add(new User("AAA"));
        userStore.add(new User("DDD"));
        userStore.add(new User("SSS"));
    }

    @Test
    public void whenIdSSSS() {
        User result = userStore.findById("SSS");
        assertThat(result.getId(), is("SSS"));
    }

    @Test
    public void whenDeleteSSS() {
        boolean del = userStore.delete("SSS");
        assertThat(del, is(true));

    }

    @Test
    public void whenReplaceSSS() {
        boolean replace = userStore.replace("SSS", new User("XXX"));
        assertThat(replace, is(true));
        assertThat(userStore.findById("XXX").getId(), is("XXX"));

    }
}