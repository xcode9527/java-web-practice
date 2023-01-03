package com.xcode.icu.sort;

import com.xcode.icu.common.ArrayUtil;

public class MergeSort {

    public static void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        int[] result = new int[data.length];
        merge(data, result, 0, data.length - 1);
    }

    private static void merge(int[] data, int[] result, int l, int r) {
        int mid = (l + r) / 2;
        if (mid > l) {
            merge(data, result, l, mid);
        }
        if (mid + 1 < r) {
            merge(data, result, mid + 1, r);
        }

        int ls = l;
        int rs = mid + 1;
        int k = l;

        for (; ls <= mid && rs <= r; ) {
            result[k++] = data[ls] < data[rs] ? data[ls++] : data[rs++];
        }
        for (; ls <= mid; ) {
            result[k++] = data[ls++];
        }
        for (; rs <= r; ) {
            result[k++] = data[rs++];
        }
        for (; l <= r; ) {
            data[l] = result[l++];
        }
    }

    public static void main(String[] args) {
        int[] origin = ArrayUtil.createIntArray(20, false);
        for (int i : origin) {
            System.out.print(i + " ");
        }

        MergeSort.sort(origin);

        System.out.println("");
        for (int i : origin) {
            System.out.print(i + " ");
        }
    }

}
