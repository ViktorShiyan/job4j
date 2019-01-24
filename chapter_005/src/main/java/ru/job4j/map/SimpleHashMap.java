package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс реализующий ассоциативный массив на базе хэш-таблицы
 *
 * @author Viktor Shiyan
 * @since 23.01.2019
 */
public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Entry<K, V>> {

    /**
     * Хранилище элементов ключ - значение
     */
    private Entry<K, V>[] hashTable;
    /**
     * Константа - коэффициент загрузки хранилища.
     */
    private static final double LOAD_FACTOR = 0.5;

    /**
     * Константа - коэффициент увеличения хранилища.
     */
    private static final int MAGNIFICATION_FACTOR = 2;
    /**
     * Количество хранимых элементов в коллекции.
     */
    private int size;

    /**
     * Счетчик операций, которые могут повлиять на правильную работу итератора.
     */
    private int modCount;

    @SuppressWarnings("unchecked")
    public SimpleHashMap() {
        hashTable = (Entry<K, V>[]) new Entry[16];
        modCount = 0;
        size = 0;
    }

    /**
     * Метод для вставки значения по ключу
     *
     * @param key   ключ
     * @param value значение
     * @return true если вставка удалась
     */
    public boolean insert(K key, V value) {
        boolean result;
        if (LOAD_FACTOR < (this.size / (double) this.hashTable.length)) {
            increaseCapacity();
        }
        if (key == null) {
            this.hashTable[0] = new Entry<>(null, value);
            modCount++;
            result = true;
        } else {
            int hash = hash(key.hashCode());
            int index = indexFor(hash, this.hashTable.length);
            if (hashTable[index] == null || hashTable[index].getKey().equals(key)) {
                hashTable[index] = new Entry<>(key, value);
                modCount++;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Метод для удаления значения по ключу
     *
     * @param key ключ
     * @return true если удаление удалось
     */
    public boolean delete(K key) {
        boolean result;
        if (key == null) {
            this.hashTable[0] = null;
            modCount++;
            result = true;
        } else {
            int hash = hash(key.hashCode());
            int index = indexFor(hash, this.hashTable.length);
            if (hashTable[index] != null && hashTable[index].getKey().equals(key)) {
                hashTable[index] = null;
                modCount++;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Метод для получения
     *
     * @param key ключ
     * @return элемент
     */
    public V get(K key) {
        V result = null;
        if (key == null) {
            if (hashTable[0] != null) {
                result = hashTable[0].getValue();
            }
        } else {
            int hash = hash(key.hashCode());
            int index = indexFor(hash, this.hashTable.length);
            if (hashTable[index] != null) {
                result = hashTable[index].getValue();
            }
        }
        return result;
    }

    /**
     * Метод вычисляющий размер
     *
     * @return число не нулевых ячеек
     */
    public int getSize() {
        int count = 0;
        for (Entry<K, V> entry : hashTable) {
            if (entry != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Увеличивает размер таблицы и производит перехеширование
     * всех элементов, в соответствии с новым размером.
     */
    @SuppressWarnings("unchecked")
    private void increaseCapacity() {
        Entry<K, V>[] newStorage = (Entry<K, V>[]) new Entry[this.hashTable.length * MAGNIFICATION_FACTOR];
        for (Entry<K, V> entry : this.hashTable) {
            if (entry != null) {
                int hash = hash(entry.hashCode());
                int index = indexFor(hash, newStorage.length);
                newStorage[index] = entry;
            }
        }
        this.hashTable = newStorage;
    }

    /**
     * Метод определяет позицию в ячейке
     *
     * @param h      hash
     * @param length длина массива
     * @return индекс для добавления
     */
    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    /**
     * Метод определяет hash объекта
     *
     * @param h hasCode объекта
     * @return hash
     */
    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }


    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<>() {

            /**
             * Число изменений коллекции, на момент создания итератора.
             */
            private final int expectedModCount = modCount;

            /**
             * Указатель для обхода коллекции.
             */
            private int position;

            /**
             * @return возвращает индекс следующего ненулевого элемента.
             */
            private int findNextNotNullElement() {
                int result = -1;
                for (int i = this.position; i < hashTable.length; i++) {
                    if (hashTable[i] != null) {
                        result = i;
                        this.position = result;
                        break;
                    }
                }
                return result;
            }

            /**
             * @return true - если за указателем есть ненулевой элемент.
             *         false - если ненулевых элементов больше нет.
             */
            @Override
            public boolean hasNext() {
                return (this.position != -1);
            }

            /**
             * Возвращает следующий не нулевой элемент за указателем.
             * Переводит указатель на текущий ненулевой элемент + 1.
             * @return ненулевой элемент.
             */
            @Override
            public Entry<K, V> next() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int nextNotNullElementIndex = findNextNotNullElement();
                Entry<K, V> result = hashTable[findNextNotNullElement()];
                this.position = nextNotNullElementIndex + 1;
                return result;
            }
        };
    }

    /**
     * Класс, описывающий объекты, загружаемые в главное хранилище.
     *
     * @param <K> Параметризованный тип ключа.
     * @param <V> Параметризованный тип значения.
     */
    public static class Entry<K, V> {

        private K key;
        private V value;

        /**
         * Конструктор, инициализирует поля ключ, значение.
         *
         * @param key   ключ.
         * @param value значение.
         */
        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * @return ключ.
         */
        public K getKey() {
            return key;
        }

        /**
         * @return значение.
         */
        public V getValue() {
            return value;
        }
    }
}
