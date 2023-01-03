package com.xcode.icu.sort;

import com.xcode.icu.common.ArrayUtil;

public class SelectSort {

    public static void SelectSort(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        int len = data.length;
        for (int i = 0; i < len; i++) {
            int tmp = data[i];
            int flag = i;
            for (int j = i + 1; j < len; j++) {
                if (data[j] < tmp) {
                    tmp = data[j];
                    flag = j;
                }
            }
            if (flag != i) {
                data[flag] = data[i];
                data[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] origin = ArrayUtil.createIntArray(10, false);
        for (int i : origin) {
            System.out.print(i + " ");
        }

        SelectSort.SelectSort(origin);

        System.out.println("");
        for (int i : origin) {
            System.out.print(i + " ");
        }
    }

}
