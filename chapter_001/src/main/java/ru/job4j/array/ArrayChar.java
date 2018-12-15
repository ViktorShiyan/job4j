package ru.job4j.array;

/**
 * Обертка над строкой.
 *
 * @author Viktor Shiyan
 * @since 18.12.2018
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = false;
        String intermediate = "";
        char[] value = prefix.toCharArray();
        for (int i = 0; i < data.length; i++) {
            intermediate += data[i];
            if (intermediate.equals(prefix)) {
                result = true;
                break;
            }
        }
        return result;
    }
}