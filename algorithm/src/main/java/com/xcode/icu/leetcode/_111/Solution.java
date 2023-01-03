package com.xcode.icu.leetcode._111;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 1;
        List<TreeNode> tns = new ArrayList<>();
        tns.add(root);

        while (tns.size() != 0) {
            int n = tns.size();
            List<TreeNode> nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = tns.get(i);
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            tns = nodes;
            depth++;
        }
        return depth;
    }

}