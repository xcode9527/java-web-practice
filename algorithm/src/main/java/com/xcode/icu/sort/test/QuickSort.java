package com.xcode.icu.sort.test;

import com.xcode.icu.common.ArrayUtil;

public class QuickSort {

    public void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        recursion(data, 0, data.length - 1);
    }

    private void recursion(int[] data, int l, int r) {
        int index = findIndex(data, l, r);
        if (index - 1 > l) {
            recursion(data, l, index - 1);
        }
        if (index + 1 < r) {
            recursion(data, index + 1, r);
        }
    }

    private int findIndex(int[] data, int l, int r) {
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
        int[] nums = ArrayUtil.createIntArray(20, false);
        for (int num : nums) {
            System.out.print(num + " ");
        }

        new QuickSort().sort(nums);
        System.out.println("");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
