package com.xcode.icu.leetcode._226;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> tns = new ArrayList<>();
        tns.add(root);

        while (tns.size() != 0) {
            List<TreeNode> nodes = new ArrayList<>();
            for (int i = 0; i < tns.size(); i++) {
                TreeNode node = tns.get(i);
                if (node.left != null || node.right != null) {
                    TreeNode swap = node.left;
                    node.left = node.right;
                    node.right = swap;
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            tns = nodes;
        }
        return root;
    }
}