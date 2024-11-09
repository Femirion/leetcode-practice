package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/description/
 */
public class PathSumIII {

    private int counter = 0;

    /**
     * Runtime 18 ms Beats 43.96%
     * Memory 42.62 MB Beats 97.82%
     */
    public int pathSum(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }

        findPathSum(root, target, 0);
        pathSum(root.left, target);
        pathSum(root.right, target);

        return counter;
    }

    private void findPathSum(TreeNode node, int target, long sum) {
        if (node == null) {
            return;
        }

        sum = sum + node.val;
        if (target == sum) {
            counter++;
        }

        findPathSum(node.left, target, sum);
        findPathSum(node.right, target, sum);
    }
}
