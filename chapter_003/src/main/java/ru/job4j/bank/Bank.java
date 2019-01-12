package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс описывающий работу банка на MAP
 *
 * @author Viktor Shiayn
 * @since 10.01.2019
 */
public class Bank {
    private Map<User, List<Account>> userAccounts = new HashMap<>();

    /**
     * Метод для добавления нового пользователя
     *
     * @param user новый пользователь
     */
    public void addUser(User user) {
        this.userAccounts.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод для удаления пользователя
     *
     * @param user удаляемый пользователь
     */
    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }

    /**
     * Метод добавляющий счет пользователю
     *
     * @param passport паспорт пользователя
     * @param account  счёт
     */
    public void addAccountToUser(String passport, Account account) {
        for (User user : this.userAccounts.keySet()) {
            if (user.getPassport().equals(passport) && !this.userAccounts.get(user).contains(account)) {
                this.userAccounts.get(user).add(account);
                break;
            }
        }
    }

    /**
     * Метод удаляющий счёт у пользователя
     *
     * @param passport паспорт пользователя
     * @param account  счёт
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : this.userAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.userAccounts.get(user).remove(account);
                break;
            }
        }
    }

    /**
     * Получение всех счетов пользователя
     *
     * @param passport паспорт пользователя
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result;
        User user = this.userAccounts.keySet().stream().filter(userSearch -> userSearch.getPassport().equals(passport)).collect(Collectors.toList()).get(0);
        result = this.userAccounts.get(user);
        return result;
    }

    /**
     * Метод обмена денег
     *
     * @param srcPassport   паспорт отправителя
     * @param srcRequisite  реквизиты отправителя
     * @param destPassport  паспорт получателя
     * @param destRequisite реквизиты получателя
     * @param amount        сумма перевода
     * @return прошла операция или нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = true;
        Account srcAccount = this.findByRequsiteAndPassport(srcPassport, srcRequisite);
        Account destAccount = this.findByRequsiteAndPassport(destPassport, destRequisite);
        if (srcAccount == null || destAccount == null) {
            result = false;
        } else if (srcAccount.getValue() - amount < 0) {
            result = false;
        } else {
            srcAccount.setValue(srcAccount.getValue() - amount);
            destAccount.setValue(destAccount.getValue() + amount);
        }
        return result;
    }

    /**
     * Возвращает счет
     *
     * @param list список счетов
     * @param req  реквизиты
     * @return счёт
     */
    private Account findByRequsite(List<Account> list, String req) {
        Account result;
        result = list.stream().filter(account -> account.getRequisits().equals(req)).collect(Collectors.toList()).get(0);
        return result;
    }

    /**
     * Метод для поиска счета по паспорту и реквизитам
     *
     * @param passport  паспорт
     * @param requisits реквизиты счета
     * @return счет
     */
    private Account findByRequsiteAndPassport(String passport, String requisits) {
        Account accountResult;
        User userRes;
        userRes = this.userAccounts.keySet().stream().filter(account -> account.getPassport()
                .equals(passport)).collect(Collectors.toList()).get(0);

        accountResult = this.userAccounts.get(userRes).stream().filter(account -> account
                .getRequisits().equals(requisits)).collect(Collectors.toList()).get(0);
        return accountResult;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<User, List<Account>> entry : this.userAccounts.entrySet()) {
            result.append(entry.getKey().toString()).append(":\n");
            for (Account account : entry.getValue()) {
                result.append("- ").append(account.toString()).append("\n");
            }
        }
        return result.toString();
    }

    public Map<User, List<Account>> getBankList() {
        return this.userAccounts;
    }
}