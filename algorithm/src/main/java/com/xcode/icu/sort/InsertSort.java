package com.xcode.icu.sort;

import com.xcode.icu.common.ArrayUtil;

public class InsertSort {

    public static void insertSort(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        int len = data.length;
        for (int i = 1; i < len; i++) {
            int swap = data[i];
            int j = i;
            if (data[j - 1] > swap) {
                for (; j >= 1 && data[j - 1] >= swap; ) {
                    data[j] = data[j - 1];
                    j--;
                }
            }
            data[j] = swap;
        }
    }

    public static void main(String[] args) {
        int[] origin = ArrayUtil.createIntArray(10, false);
        for (int i : origin) {
            System.out.print(i + " ");
        }

        InsertSort.insertSort(origin);

        System.out.println("");
        for (int i : origin) {
            System.out.print(i + " ");
        }
    }

}
