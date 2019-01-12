package ru.job4j.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест класса банк
 *
 * @author ViktorShiyan
 * @since 09.01.2019
 */
public class BankTest {
    private Bank bank;
    private User user1;
    private User user2;
    private Account account1;
    private Account account2;

    @Before
    public void before() {
        bank = new Bank();
        user1 = new User("Viktor", "555555");
        user2 = new User("Ivan", "444444");
        account1 = new Account(1000, "000000");
        account2 = new Account(10000, "000001");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user1.getPassport(), account2);
    }

    /**
     * Тест добавления пользователя
     */
    @Test
    public void addUser() {
        Map<User, List<Account>> map = bank.getBankList();
        assertThat(true, is(map.keySet().contains(user1)));
    }

    /**
     * тест на Удаление пользователя
     */
    @Test
    public void deleteUser() {
        bank.deleteUser(user1);
        Map<User, List<Account>> map = bank.getBankList();
        assertThat("Ivan", is(map.keySet().iterator().next().getName()));
    }

    /**
     * Тест на добавление счета пользователю
     */
    @Test
    public void addAccountToUser() {
        List<Account> accountsList = bank.getUserAccounts(user1.getPassport());
        assertThat(account1, is(accountsList.iterator().next()));
    }

    /**
     * Тест на удаление счета у пользователя
     */
    @Test
    public void deleteAccountFromUser() {
        bank.deleteAccountFromUser(user1.getPassport(), account1);
        List<Account> accountsList = bank.getUserAccounts(user1.getPassport());
        assertThat(account2, is(accountsList.iterator().next()));
    }

    /**
     * Получить все счета пользователя
     */
    @Test
    public void getUserAccounts() {
        List<Account> accountsList = bank.getUserAccounts(user1.getPassport());
        assertThat(account1, is(accountsList.get(0)));
        assertThat(account2, is(accountsList.get(1)));
    }

    /**
     * Удачный перевод
     */
    @Test
    public void transferMoney() {
        List<Account> accountsList = bank.getUserAccounts(user1.getPassport());
        bank.transferMoney(user1.getPassport(), account1.getRequisits(), user1.getPassport(), account2.getRequisits(), 1000);
        assertThat(0.0, is(accountsList.iterator().next().getValue()));
    }

    /**
     * Неудачный перевод
     */
    @Test
    public void transferMoneyFalse() {
        boolean expect = bank.transferMoney(user1.getPassport(), account1.getRequisits(), user1.getPassport(), account2.getRequisits(), 999999);
        assertThat(false, is(expect));
    }
}