package com.xcode.icu.leetcode._20;

import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (list.size() != 0 && match(list.getLast(),ch)) {
                list.removeLast();
            }else {
                list.add(ch);
            }
        }
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    private boolean match(Character origin,Character target) {
        if (origin == '(' && target == ')') {
            return true;
        }
        if (origin == '[' && target == ']') {
            return true;
        }
        if (origin == '{' && target == '}') {
            return true;
        }
        return false;
    }
}