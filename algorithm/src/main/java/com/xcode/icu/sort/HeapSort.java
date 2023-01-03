package com.xcode.icu.sort;

import com.xcode.icu.common.ArrayUtil;

public class HeapSort {

    public void sort(int[] data) {

        /**
         * 下标为 i 的节点的父节点下标  （i-1）/ 2
         * 下标为 i 的节点的左孩子下标   i*2+1
         * 下标为 i 的节点的右孩子下标   i*2+2
         * */

        int n = data.length;

        // 新建堆 - 大顶堆  n/2-1,最后一个非叶节点
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapAdjust(data, n, i);
        }

        // 排序
        for (int i = n - 1; i >= 0; i--) {
            int swap = data[i];
            data[i] = data[0];
            data[0] = swap;
            heapAdjust(data, i, 0);
        }
    }

    private static void heapAdjust(int[] data, int n, int i) {
        int big = i;
        int lson = i * 2 + 1;
        int rson = i * 2 + 2;

        if (lson < n && data[lson] > data[big]) {
            big = lson;
        }
        if (rson < n && data[rson] > data[big]) {
            big = rson;
        }
        if (big != i) {
            int swap = data[i];
            data[i] = data[big];
            data[big] = swap;
            heapAdjust(data, n, big);
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
