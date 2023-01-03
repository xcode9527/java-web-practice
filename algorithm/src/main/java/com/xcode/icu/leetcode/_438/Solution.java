package com.xcode.icu.leetcode._438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> origin = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            Integer num = origin.get(p.charAt(i));
            origin.put(p.charAt(i), num != null ? ++num : 1);
        }

        int l = 0, r = 0, valid = 0;
        List<Integer> result = new ArrayList<>();
        while (r < s.length()) {
            Character rc = s.charAt(r);
            r++;
            if (origin.containsKey(rc) && origin.get(rc) != 0) {
                Integer num = window.get(rc);
                window.put(rc, num != null ? ++num : 1);
                if (origin.get(rc) - window.get(rc) >= 0) {
                    valid++;
                }
            }

            while (r - l >= p.length()) {
                if (valid == p.length()) {
                    result.add(l);
                }
                Character lc = s.charAt(l);
                l++;
                if (origin.containsKey(lc) && origin.get(lc) != 0) {
                    if (origin.get(lc) - window.get(lc) >= 0) {
                        valid--;
                    }
                    window.put(lc, window.get(lc) - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "baa";
        String o = "aa";
        List<Integer> anagrams = findAnagrams(s, o);
        for (Integer anagram : anagrams) {
            System.out.print(anagram + " ");
        }
    }

}