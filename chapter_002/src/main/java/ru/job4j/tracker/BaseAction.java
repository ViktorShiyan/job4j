package ru.job4j.tracker;

/**
 * Абстрактный класс для для действий
 * реализующий интерфейс UserAction
 *
 * @author Viktor Shiayn
 * @since 27.12.2018
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;


    BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }
}