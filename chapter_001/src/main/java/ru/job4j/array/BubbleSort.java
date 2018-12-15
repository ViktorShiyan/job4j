package ru.job4j.array;

/**
 * Класс реализующий сортировку пузырьком
 *
 * @author Viktor Shiyan
 * @since 15.12.2018
 */
public class BubbleSort {

    /**
     * Метод реализующий сортировку пузырьком
     *
     * @param arr входной массив для сортировки
     * @return отсортированный массив
     */
    public int[] sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
