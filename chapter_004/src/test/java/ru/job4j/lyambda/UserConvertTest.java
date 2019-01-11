package ru.job4j.lyambda;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Viktor Shiyan
 * @since 11.01.2019
 */
public class UserConvertTest {

    @Test
    public void convert() {
        UserConvert userConvert = new UserConvert();
        List<String> names = Arrays.asList("Вася", "Витя");
        List<UserConvert.User> users = userConvert.convert(names, UserConvert.User::new);
        List<UserConvert.User> expect = Arrays.asList(new UserConvert.User("Вася"), new UserConvert.User("Витя"));
        assertThat(users.get(0).toString(), is(expect.get(0).toString()));
    }
}