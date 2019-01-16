package ru.job4j.array;

/**
 * Абстрактный класс основа
 *
 * @author Viktor Shiyan
 * @since 16.01.2019
 */
public abstract class Base {
    /**
     * Индивидуальный номер
     */
    private final String id;

    /**
     * Конструктор
     *
     * @param id индивидуальный нномер
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * @return идентификатор
     */
    public String getId() {
        return id;
    }
}
