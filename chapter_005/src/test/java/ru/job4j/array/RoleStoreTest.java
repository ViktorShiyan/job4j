package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    private RoleStore roleStore;

    @Before
    public void setUp() {
        roleStore = new RoleStore(5);
        roleStore.add(new Role("AAA"));
        roleStore.add(new Role("DDD"));
        roleStore.add(new Role("SSS"));
    }

    @Test
    public void whenIdSSSS() {
        Role result = roleStore.findById("SSS");
        assertThat(result.getId(), is("SSS"));
    }

    @Test
    public void whenDeleteSSS() {
        boolean del = roleStore.delete("SSS");
        assertThat(del, is(true));

    }

    @Test
    public void whenReplaceSSS() {
        boolean replace = roleStore.replace("SSS", new Role("XXX"));
        assertThat(replace, is(true));
        assertThat(roleStore.findById("XXX").getId(), is("XXX"));

    }
}