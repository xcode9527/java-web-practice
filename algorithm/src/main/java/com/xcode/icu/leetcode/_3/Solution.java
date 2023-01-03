package com.xcode.icu.leetcode._3;

import java.util.HashMap;
import java.util.Map;

/**
 * 中等难度
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, res = 0;
        while (r < s.length()) {
            Character rw = s.charAt(r);
            map.put(rw, map.containsKey(rw) ? map.get(rw) + 1 : 1);
            r++;

            while (map.get(rw) > 1) {
                Character lw = s.charAt(l);
                map.put(lw, map.get(lw) - 1);
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

}