package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест класса сортировки пузырьком
 *
 * @author Viktor Shiyan
 * @since 15.12.2018
 */
public class BubbleSortTest {

    /**
     * тест метода сортирущего пузырьком
     */
    @Test
    public void sort() {
        BubbleSort testSorter = new BubbleSort();
        int[] arr = {1, 9, 8, 4, 3, 6};
        int[] expect = {1, 3, 4, 6, 8, 9};
        assertThat(testSorter.sort(arr), is(expect));
    }

    /**
     * тест метода слияния двух отсортированных массивов
     */
    @Test
    public void twoInOne() {
        BubbleSort testSorter = new BubbleSort();
        int[] arrOne = {1, 3, 5, 6};
        int[] arrTwo = {2, 4, 7};
        int[] expect = {1, 2, 3, 4, 5, 6, 7};
        assertThat(testSorter.twoInOneSort(arrOne, arrTwo), is(expect));
    }
}