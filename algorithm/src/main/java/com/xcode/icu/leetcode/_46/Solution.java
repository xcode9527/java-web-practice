package com.xcode.icu.leetcode._46;

import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] path = new boolean[nums.length];
        traverse(nums, track, path);
        return res;
    }

    public void traverse(int[] nums, LinkedList<Integer> track, boolean[] path) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path[i]) {
                continue;
            }
            track.add(nums[i]);
            path[i] = true;
            traverse(nums, track, path);
            track.removeLast();
            path[i] = false;
        }
    }
}