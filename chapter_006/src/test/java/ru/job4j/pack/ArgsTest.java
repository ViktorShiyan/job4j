package ru.job4j.pack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ArgsTest {
    Args args;
    String[] keyStart;

    @Before
    public void setUp() throws Exception {
        keyStart = new String[]{"-d", "directory", "-e", "1", "2", "3", "-o", "output"};
        args = new Args(keyStart);
    }

    @Test
    public void directory() {
        assertThat(args.directory(), is("directory"));
    }

    @Test
    public void output() {
        assertThat(args.output(), is("output"));
    }

    @Test
    public void exclude() {
        assertThat(args.exclude(), is(new String[]{"1", "2", "3"}));
    }
}