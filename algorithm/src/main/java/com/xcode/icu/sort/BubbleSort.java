package com.xcode.icu.sort;

import com.xcode.icu.common.ArrayUtil;

public class BubbleSort {

    public static void bubbleSort(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        int len = data.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int swap = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = swap;
                }
            }
        }
    }

    public static void sortMax(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        int len = data.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (data[j] < data[j + 1]) {
                    int swap = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = swap;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] origin = ArrayUtil.createIntArray(10, false);
        for (int i : origin) {
            System.out.print(i + " ");
        }

        BubbleSort.sortMax(origin);

        System.out.println("");
        for (int i : origin) {
            System.out.print(i + " ");
        }
    }

}
