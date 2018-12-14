package ru.job4j.array;

/**
 * Класс пероеворачивающий массив
 *
 * @author Viktor Shiayn
 * @since 14.12.2018
 */
public class Turn {
    /**
     * Метод переворачивающий массив
     *
     * @param array входной массив
     * @return перевернутый массив
     */
    public int[] back(int[] array) {
        int temporary;
        for (int i = 0; i < array.length / 2; i++) {
            temporary = array[array.length - (i + 1)];
            array[array.length - (i + 1)] = array[i];
            array[i] = temporary;
        }
        return array;
    }
}
