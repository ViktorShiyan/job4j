package ru.job4j.tracker;

/**
 * Класс наследующий консольный ввод, но с перегруженым методом
 * для валидации
 *
 * @author Viktor Shiyan
 * @since 26.12.18
 */
public class ValidInput implements Input {

    private final Input input;

    ValidInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutExeption moe) {
                System.out.println("Введите пункт не выходящий из диапозона.");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите коректные данные");
            }
        } while (invalid);
        return value;
    }
}
