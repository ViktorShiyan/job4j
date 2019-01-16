package ru.job4j.array;

public class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    /**
     * Метод для добавления модели
     *
     * @param model добавляемая модель
     */
    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    /**
     * Вставка по ID
     *
     * @param id    идентификатор
     * @param model Модель
     * @return true если успешно
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int findIndex = this.findIndexById(id);
        if (findIndex != -1) {
            this.simpleArray.set(findIndex, model);
            result = true;
        }
        return result;
    }

    /**
     * Удаление
     *
     * @param id идентификатор модели
     * @return true усли удалилось
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        int findIndex = this.findIndexById(id);
        if (findIndex != -1) {
            this.simpleArray.remove(findIndex);
            result = true;
        }
        return result;
    }

    /**
     * Поиск по Id
     *
     * @param id идентификатор
     * @return модель
     */
    @Override
    public T findById(String id) {
        T result = null;
        int findIndex = this.findIndexById(id);
        if (findIndex != -1) {
            result = this.simpleArray.get(findIndex);
        }
        return result;
    }

    /**
     * Метод находящий индекс по ID
     *
     * @param id идентификатор
     * @return индекс
     */
    private int findIndexById(String id) {
        int result = -1;
        int index = 0;
        T temp;
        for (Object o : this.simpleArray) {
            temp = (T) o;
            if (temp.getId().equals(id)) {
                result = index;
                break;
            }
            index++;
        }
        return result;
    }
}
