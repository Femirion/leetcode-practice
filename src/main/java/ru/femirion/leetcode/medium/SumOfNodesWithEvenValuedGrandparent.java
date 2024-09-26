package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/
 */
public class SumOfNodesWithEvenValuedGrandparent {

    private int sum = 0;

    /**
     * Runtime 1 ms Beats 100.00%
     * Memory 45.90 MB Beats 72.48%
     */
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverseTheTree(root, false, false);
        return sum;
    }

    private void traverseTheTree(TreeNode node, boolean isGrandPaEven, boolean isParentEven) {
        if (node == null) {
            return;
        }

        int tmpSum = sum;
        var tmpNode = node;

        if (isGrandPaEven) {
            sum = sum + node.val;
        }

        traverseTheTree(node.left, isParentEven, node.val % 2 == 0);
        traverseTheTree(node.right, isParentEven, node.val % 2 == 0);
    }
}
