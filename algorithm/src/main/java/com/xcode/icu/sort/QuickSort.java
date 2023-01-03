package com.xcode.icu.sort;

import com.xcode.icu.common.ArrayUtil;

public class QuickSort {

    public static void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        quick(data, 0, data.length - 1);
    }

    private static void quick(int[] data, int l, int r) {
        int offset = offset(data, l, r);
        if (offset - 1 > l) {
            quick(data, l, offset - 1);
        }
        if (offset + 1 < r) {
            quick(data, offset + 1, r);
        }
    }

    private static int offset(int[] data, int l, int r) {
        int key = data[r];
        while (l < r) {
            while (l < r && data[l] <= key) {
                l++;
            }
            data[r] = data[l];
            while (l < r && data[r] >= key) {
                r--;
            }
            data[l] = data[r];
        }
        data[r] = key;
        return r;
    }


    public static void main(String[] args) {
        int[] origin = ArrayUtil.createIntArray(20, false);
        for (int i : origin) {
            System.out.print(i + " ");
        }

        QuickSort.sort(origin);

        System.out.println("");
        for (int i : origin) {
            System.out.print(i + " ");
        }
    }

}
