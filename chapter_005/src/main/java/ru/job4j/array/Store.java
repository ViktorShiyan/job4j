package ru.job4j.array;

/**
 * Интерфейс хранилища
 *
 * @author Viktor Shiyan
 * @since 16.01.2019
 */
public interface Store<T extends Base> {
    /**
     * Добавить модель в хранилище
     *
     * @param model добавляемая модель
     */
    void add(T model);

    /**
     * Вставить по индексу
     *
     * @param id    идентификатор
     * @param model Модель
     * @return true если замена прошла
     */
    boolean replace(String id, T model);

    /**
     * Удаление модели
     *
     * @param id идентификатор модели
     * @return true если успешно
     */
    boolean delete(String id);

    /**
     * Поиск по идентификатору
     *
     * @param id идентификатор
     * @return искомая модель или null
     */
    T findById(String id);
}

