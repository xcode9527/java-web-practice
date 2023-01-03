package com.xcode.icu.sort.test;

import com.xcode.icu.common.ArrayUtil;

public class HeapSort {

    public void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }

        int n = data.length;

        // 建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapAdjust(data, n, i);
        }

        // 排序
        for (n = n - 1; n >= 0; n--) {
            int swap = data[0];
            data[0] = data[n];
            data[n] = swap;
            heapAdjust(data, n, 0);
        }
    }

    private void heapAdjust(int[] data, int n, int i) {
        int root = i;
        int lson = i * 2 + 1;
        int rson = i * 2 + 2;

        if (lson < n && data[lson] > data[root]) {
            root = lson;
        }
        if (rson < n && data[rson] > data[root]) {
            root = rson;
        }
        if (root != i) {
            int swap = data[root];
            data[root] = data[i];
            data[i] = swap;
            heapAdjust(data, n, root);
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.createIntArray(20, false);
        for (int num : nums) {
            System.out.print(num + " ");
        }

        new HeapSort().sort(nums);

        System.out.println("");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
