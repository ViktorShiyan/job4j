package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Преобразует итератор итераторов в итереатор
 *
 * @author Viktor Shiayn
 * @since 15.01.2019
 */
public class IteratorForIterators {
    /**
     * Метод конвертирует итератор с вложенными итераторами в итератор чисел.
     *
     * @param it - итератор с вложенными итераторами.
     * @return итератор чисел.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {

            private Iterator<Integer> currentNestedIt = initialCurrentNestedIt();

            /**
             * Инициализирует поле currentNestedIt.
             * @return первый непустой вложенный итератор, либо, если все
             * вложенные итераторы пусты - последним вложенным итератором.
             */
            private Iterator<Integer> initialCurrentNestedIt() {
                Iterator<Integer> currentNestedIt = it.next();
                while (!currentNestedIt.hasNext() && it.hasNext()) {
                    currentNestedIt = it.next();
                }
                return currentNestedIt;
            }

            /**
             * Проверяет наличие следующего элемента.
             * @return true - если элемент есть,
             *         false - если элементов больше нет.
             */
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (this.currentNestedIt.hasNext()) {
                    result = true;
                } else {
                    while (it.hasNext()) {
                        this.currentNestedIt = it.next();
                        if (this.currentNestedIt.hasNext()) {
                            result = true;
                            break;
                        }
                    }
                }
                return result;
            }

            /**
             * Возвращает число и сдвигает указатель, обходя все вложенные итераторы.
             * @return текущее число под указателем.
             */
            @Override
            public Integer next() {
                Integer result;
                if (!this.hasNext()) {
                    throw new NoSuchElementException("нет элементов");
                }
                result = currentNestedIt.next();
                return result;
            }
        };
    }
}
