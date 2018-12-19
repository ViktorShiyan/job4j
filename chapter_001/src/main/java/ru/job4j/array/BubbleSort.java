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

    /**
     * Метод реализующий слияние двух отсортированных массивов
     *
     * @param arrOne входной массив для сложения
     * @param arrTwo входной массив для сложения
     * @return отсортированный массив
     */
    public int[] twoInOneSort(int[] arrOne, int[] arrTwo) {
        int[] arrRsl = new int[arrOne.length + arrTwo.length];
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < arrRsl.length; i++) {
            if (firstIndex >= arrOne.length) {
                arrRsl[i] = arrTwo[secondIndex];
                secondIndex += 1;
            } else if (secondIndex >= arrTwo.length) {
                arrRsl[i] = arrOne[firstIndex];
                firstIndex += 1;
            } else if (arrOne[firstIndex] < arrTwo[secondIndex]) {
                arrRsl[i] = arrOne[firstIndex];
                firstIndex += 1;
            } else {
                arrRsl[i] = arrTwo[secondIndex];
                secondIndex += 1;
            }
        }
        return arrRsl;
    }
}
