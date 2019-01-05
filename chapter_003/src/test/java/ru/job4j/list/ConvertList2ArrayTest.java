package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when9ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2X2Array() {
        ConvertList2Array list2Array = new ConvertList2Array();
        List<int[]> listArrayInt = new ArrayList<>();
        listArrayInt.add(new int[]{1, 2});
        listArrayInt.add(new int[]{3, 4});
        List<Integer> result = list2Array.convert(listArrayInt);
        List<Integer> expect = new ArrayList<Integer>();
        for (int i = 1; i < 5; i++) {
            expect.add(i);
        }
        assertThat(result, is(expect));
    }

    @Test
    public void when2And6Array() {
        ConvertList2Array list2Array = new ConvertList2Array();
        List<int[]> listArrayInt = new ArrayList<>();
        listArrayInt.add(new int[]{1, 2});
        listArrayInt.add(new int[]{3, 4, 5, 6, 7, 8});
        List<Integer> result = list2Array.convert(listArrayInt);
        List<Integer> expect = new ArrayList<Integer>();
        for (int i = 1; i < 9; i++) {
            expect.add(i);
        }
        assertThat(result, is(expect));
    }
}