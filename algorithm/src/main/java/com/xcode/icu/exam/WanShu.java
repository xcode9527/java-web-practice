package com.xcode.icu.exam;

public class WanShu {

    public static boolean valid(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum == num) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 1000; i++) {
            if (valid(i)) {
                for (int j = 1; j < i; j++) {
                    if (i % j == 0) {
                        System.out.print(j + " ");
                    }
                }
                System.out.println("\n" + i + " is wanshu");
            }
        }
    }

}
