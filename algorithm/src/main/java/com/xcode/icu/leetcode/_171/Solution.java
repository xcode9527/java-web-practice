package com.xcode.icu.leetcode._171;

class Solution {
    public int titleToNumber(String columnTitle) {
        byte A = 'A';
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char letter = columnTitle.charAt(i);
            result = result + (letter - A + 1) * pow(26, columnTitle.length() - i - 1);
        }
        return result;
    }

    private int pow(int a, int b) {
        int c = 1;
        for (int i = 0; i < b; i++) {
            c *= a;
        }
        return c;
    }
}



