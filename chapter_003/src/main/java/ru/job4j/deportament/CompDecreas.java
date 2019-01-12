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
        char[] chars1 = o1.toCharArray();
        char[] chars2 = o2.toCharArray();
        int res = 0;
        for (int i = 0; i < chars1.length && i < chars2.length && !o1.equals(o2); i++) {
            char s1 = chars1[i];
            char s2 = chars2[i];
            if (s1 > s2) {
                res = -1;
                break;
            } else if (s1 < s2) {
                res = 1;
                break;
            }
        }
        if (res == 0 && o1.length() > o2.length()) {
            res = 1;
        } else if (res == 0 && o1.length() < o2.length()) {
            res = -1;
        }
        return res;
    }
}
