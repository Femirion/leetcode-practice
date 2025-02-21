package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1261. Find Elements in a Contaminated Binary Tree
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/description/
 */
public class FindElementsInAContaminatedBinaryTree {

    private Set<Integer> existedValues = new HashSet<>();

    /**
     * Runtime 21 ms Beats 72.24%
     * Memory 47.40 MB Beats 67.12%
     */
    public FindElementsInAContaminatedBinaryTree(TreeNode root) {
        populateTheTree(root, 0);
        existedValues.add(0);
    }

    public boolean find(int target) {
        return existedValues.contains(target);
    }

    private void populateTheTree(TreeNode node, int curVal) {
        var x = existedValues;

        if (node == null) {
            return;
        }

        if (node.left != null) {
            int leftVal = curVal * 2 + 1;
            existedValues.add(leftVal);
            populateTheTree(node.left, leftVal);
        }

        if (node.right != null) {
            int rightVal = curVal * 2 + 2;
            existedValues.add(rightVal);
            populateTheTree(node.right, rightVal);
        }
    }
}
