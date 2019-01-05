package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Viktor Shiayn
 * @since 05.01.2019
 */
public class UserConvertTest {

    @Test
    public void process() {
        UserConvert userConvert = new UserConvert();
        User userOne = new User(1, "Ivan", "Omsk");
        User userTwo = new User(2, "Viktor", "Omsk");
        List<User> userList = new ArrayList<User>();
        userList.add(userOne);
        userList.add(userTwo);
        HashMap<Integer, User> result = userConvert.process(userList);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(userOne.getId(), userOne);
        expect.put(userTwo.getId(), userTwo);
        assertThat(result, is(expect));
    }
}