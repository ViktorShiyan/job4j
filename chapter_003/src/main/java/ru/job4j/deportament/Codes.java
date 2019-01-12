package ru.job4j.deportament;

import java.util.*;

/**
 * Класс реализующий храение кодов подразделений
 *
 * @author Viktor Shiyan
 * @since 12.01.2019
 */
public class Codes {
    private String[] codes;

    /**
     * Конструктор
     *
     * @param codes массив с кодами для инициализации внутренего массива
     */
    Codes(String[] codes) {
        this.codes = this.complement(codes);
    }

    /**
     * Метод сортирующий массив подразделений по возрастанию
     *
     * @return отсортированный массив
     */
    public String[] sortAscending() {
        return this.codes;
    }

    /**
     * Метод сортирующий массив подразделений по убыванию
     *
     * @return отсортированный массив
     */
    public String[] sortingDecreasing() {
        Arrays.sort(this.codes, new CompDecreas());
        return this.codes;
    }

    /**
     * Метод добавляющий в массив не достающие подразделения
     *
     * @return полный массив
     */
    private String[] complement(String[] strings) {
        Set<String> setResult = new TreeSet<>();
        for (String partOut : strings) {
            StringBuilder stringBuilder = new StringBuilder("");
            for (String partIn : partOut.split("\\\\")) {
                if (stringBuilder.toString().equals("")) {
                    setResult.add(partIn);
                    stringBuilder.append(partIn);
                } else {
                    stringBuilder.append(String.format("\\%s", partIn));
                    setResult.add(stringBuilder.toString());
                }
            }

        }
        strings = setResult.toArray(new String[setResult.size()]);
        return strings;
    }
}
