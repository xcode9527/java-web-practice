package com.xcode.icu.sort.test;

import com.xcode.icu.common.ArrayUtil;

public class MergeSort {

    public void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        int[] swap = new int[data.length];
        merge(data, swap, 0, data.length - 1);
    }

    public static void merge(int[] data, int[] swap, int l, int r) {
        int mid = (l + r) / 2;
        if (mid > l) {
            merge(data, swap, l, mid);
        }
        if (mid + 1 < r) {
            merge(data, swap, mid + 1, r);
        }

        int ls = l;
        int rs = mid + 1;
        int k = l;

        while (ls <= mid && rs <= r) {
            swap[k++] = data[ls] < data[rs] ? data[ls++] : data[rs++];
        }
        while (ls <= mid) {
            swap[k++] = data[ls++];
        }
        while (rs <= r) {
            swap[k++] = data[rs++];
        }
        while (l <= r) {
            data[l] = swap[l++];
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.createIntArray(20, false);
        for (int num : nums) {
            System.out.print(num + " ");
        }

        new MergeSort().sort(nums);

        System.out.println("");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
