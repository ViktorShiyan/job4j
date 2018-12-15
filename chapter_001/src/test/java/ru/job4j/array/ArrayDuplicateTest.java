package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

/**
 * Тест класса удаляющий дубликаты в массиве
 *
 * @author Viktor Shiyan
 * @since 15.12.2018
 */
public class ArrayDuplicateTest {

    /**
     * Тест метода удаляющего дубликаты в массиве
     */
    @Test
    public void remove() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] date = {"dog", "dog", "cat", "dog", "mouse"};
        String[] expecp = {"dog", "cat", "mouse"};
        assertThat(arrayDuplicate.remove(date), arrayContainingInAnyOrder(expecp));
    }
}