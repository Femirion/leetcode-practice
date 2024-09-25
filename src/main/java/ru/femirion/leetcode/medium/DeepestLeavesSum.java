package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 1302. Deepest Leaves Sum
 * https://leetcode.com/problems/deepest-leaves-sum/description/
 */
public class DeepestLeavesSum {

    int firstLeafLevel;
    int firstLeafValue;
    int secondLeafLevel;
    int secondLeafValue;

    /**
     * Runtime 2 ms Beats 84.75%
     * Memory 46.86 MB Beats 12.05%
     */
    public int deepestLeavesSum(TreeNode root) {
        findTwoLevelInTheTree(root, 0);
        sumTheLeaves(root, 0);
        return firstLeafValue + secondLeafValue;
    }

    private void sumTheLeaves(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (firstLeafLevel == level) {
                firstLeafValue = firstLeafValue + node.val;
                return;
            }
            if (secondLeafLevel == level) {
                secondLeafLevel = secondLeafLevel + node.val;;
            }
            return;
        } else {
            sumTheLeaves(node.left, level + 1);
            sumTheLeaves(node.right, level + 1);
        }
    }

    private void findTwoLevelInTheTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (firstLeafLevel < level) {
                secondLeafLevel = firstLeafLevel;
                firstLeafLevel = level;
                return;
            }
            if (secondLeafLevel < level) {
                secondLeafLevel = level;
            }
            return;
        } else {
            findTwoLevelInTheTree(node.left, level + 1);
            findTwoLevelInTheTree(node.right, level + 1);
        }
    }
}
