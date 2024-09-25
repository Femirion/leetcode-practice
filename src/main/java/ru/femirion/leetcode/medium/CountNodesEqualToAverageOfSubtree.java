package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 2265. Count Nodes Equal to Average of Subtree
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/
 */
public class CountNodesEqualToAverageOfSubtree {

    private int totalCount;

    /**
     * Runtime 1 ms Beats 50.32%
     * Memory 44.11 MB Beats 43.56%
     */
    public int averageOfSubtree(TreeNode root) {
        traverseThroughTheTree(root);
        return totalCount;
    }

    private TraverseResult traverseThroughTheTree(TreeNode node) {
        if (node == null) {
            return new TraverseResult();
        }
        TraverseResult leftSubTreeAverage = traverseThroughTheTree(node.left);
        TraverseResult rigthSubTreeAverage = traverseThroughTheTree(node.right);

        int value = node.val + leftSubTreeAverage.sum + rigthSubTreeAverage.sum;
        int count = 1 + leftSubTreeAverage.count + rigthSubTreeAverage.count;

        if (node.val == (value / count)) {
            totalCount++;
        }
        return new TraverseResult(value, count);
    }

    private static class TraverseResult {
        int sum;
        int count;

        public TraverseResult() {}

        public TraverseResult(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
}
