package ru.job4j.deportament;

import java.util.Comparator;

/**
 * Comparetor позволяющий сортировать String в обратном порядке
 *
 * @author Viktor Shiyan
 * @since 12.01.2019
 */
public class CompDecreas implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int result;
        if (o2.startsWith(o1)) {
            result = -1;
        } else if (o1.startsWith(o2)) {
            result = 1;
        } else {
            result = o2.compareTo(o1);
        }
        return result;
    }
}
