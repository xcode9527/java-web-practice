package com.xcode.icu.common;

import java.util.Random;

public class ArrayUtil {

    public static int[] createIntArray(int len, boolean ordered) {
        if (len <= 0) {
            throw new RuntimeException("len must not null or 0");
        }
        Random r = new Random();
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            if (ordered) {
                ints[i] = i + 1;
            } else {
                ints[i] = r.nextInt(len - 1 > 10 ? len - 1 : 10) + 1;
            }
        }
        return ints;
    }

    public static int[] shuffle(int len) {
        int[] data = ArrayUtil.createIntArray(len, true);
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            ArrayUtil.swap(data, r.nextInt(len - 1), i);
        }
        return data;
    }

    private static void swap(int[] data, int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }


    public static void main(String[] args) {
        int[] x = ArrayUtil.shuffle(20);
        for (int i : x) {
            System.out.print(i + " ");
        }
    }

}
