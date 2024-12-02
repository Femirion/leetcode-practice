package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. Sum Root to Leaf Numbers
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */
public class SumRootToLeafNumbers {


    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.40 MB Beats 25.06%
     */
    List<Integer> nums = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        traverseTree(root, 0);
        int result = 0;
        for (int num : nums) {
            result = result + num;
        }
        return result;
    }

    private void traverseTree(TreeNode node, int curSum) {
        if (node == null) {
            return;
        }


        int nextSum = curSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            nums.add(nextSum);
            return;
        }

        traverseTree(node.left, nextSum);
        traverseTree(node.right, nextSum);
    }
}
