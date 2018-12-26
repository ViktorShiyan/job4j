package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Класс реализующий ввод через консоль
 *
 * @author Viktor Shiyan
 * @since 24.12.2108
 */
public class ConsoleInput implements Input {

    private Scanner in = new Scanner(System.in);

    /**
     * Метод задающий вопрос
     *
     * @param question вопрос
     * @return ответ от пользователя
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return in.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        System.out.println(question);
        int key = Integer.valueOf(in.nextLine());
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutExeption("Вышел из диапозона");
        }
        return key;
    }
}
