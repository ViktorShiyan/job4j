package ru.job4j.analize;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    @Test
    public void when2Delete2Change2New() {
        Analize.User user1 = new Analize.User(1, "1");
        Analize.User user2 = new Analize.User(2, "2");
        Analize.User user3 = new Analize.User(3, "3");
        Analize.User user4 = new Analize.User(4, "4");
        Analize.User user5 = new Analize.User(5, "5");
        Analize.User user6 = new Analize.User(6, "6");
        Analize.User user7 = new Analize.User(7, "7");
        List<Analize.User> listPrev = Arrays.asList(user1, user2, user3, user4, user5, user6, user7);
        List<Analize.User> listCurrent = new ArrayList<>(listPrev);
        listCurrent.remove(user1);
        listCurrent.remove(user2);
        listCurrent.remove(user3);
        listCurrent.remove(user4);
        listCurrent.add(new Analize.User(3, "replace"));
        listCurrent.add(new Analize.User(4, "replace"));
        listCurrent.add(new Analize.User(8, "new"));
        listCurrent.add(new Analize.User(9, "new"));
        listCurrent.add(new Analize.User(10, "new"));
        Analize analize = new Analize();
        Analize.Info resultInfo = analize.diff(listPrev, listCurrent);
        assertThat(resultInfo.changed, is(2));
        assertThat(resultInfo.added, is(3));
        assertThat(resultInfo.deleted, is(2));
    }
}