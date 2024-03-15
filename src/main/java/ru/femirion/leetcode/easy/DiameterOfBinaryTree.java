package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.Map;

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class DiameterOfBinaryTree {

    private int max = 0;

    /**
     * Runtime 2 ms Beats 14.73% of users with Java
     * Memory 46.13 MB Beats 5.67% of users with Java
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDiameter(root);
        return max;
    }

    private Map.Entry<Integer, Integer> getDiameter(TreeNode root) {
        if (root == null) {
            return Map.entry(0, 0);
        }
        int tmp = root.val;
        Map.Entry<Integer, Integer> left = getDiameter(root.left);
        Map.Entry<Integer, Integer> right = getDiameter(root.right);
        Map.Entry<Integer, Integer> entry = Map.entry(Math.max(left.getKey(), right.getKey()) + 1, Math.max(left.getValue(), right.getValue()) + 1);
        int cur = Math.max(left.getKey(), left.getValue()) + Math.max(right.getKey(), right.getValue());
        if (cur > max) {
            max = cur;
        }
        return entry;
    }
}
