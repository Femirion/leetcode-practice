package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
 */
public class MaximumLevelSumOfABinaryTree {

    private Map<Integer, Integer> levels = new HashMap<>();
    private int max = Integer.MIN_VALUE;

    /**
     * Runtime 9 ms Beats 44.30%
     * Memory 47.19 MB Beats 73.92%
     */
    public int maxLevelSum(TreeNode root) {
        helper(root, 1);

        int maxValue = Integer.MIN_VALUE;
        int maxLevel = -1;

        for (Map.Entry<Integer,Integer> level: levels.entrySet()) {
            if (maxValue < level.getValue()) {
                maxValue = level.getValue();
                maxLevel = level.getKey();
            }
        }

        return maxLevel;
    }

    /**
     * Runtime 14 ms Beats 8.87%
     * Memory 48.44 MB Beats 7.06%
     */
    public int maxLevelSum2(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        int maxLevel = -1;
        Queue<Item> items = new ArrayDeque<>();

        items.add(new Item(root, 1));
        int curLevel = 1;

        while (!items.isEmpty()) {
            Item item = items.poll();
            if (item.node == null) {
                continue;
            }
            if (item.level == curLevel) {
                curSum = curSum + item.node.val;
                items.add(new Item(item.node.left, item.level + 1));
                items.add(new Item(item.node.right, item.level + 1));
            } else {
                if (maxSum < curSum) {
                    maxSum = curSum;
                    maxLevel = curLevel;
                }
                curSum = item.node.val;
                items.add(new Item(item.node.left, item.level + 1));
                items.add(new Item(item.node.right, item.level + 1));
                curLevel++;
            }
        }

        if (maxSum < curSum) {
            maxSum = curSum;
            maxLevel = curLevel;
        }

        return maxLevel;
    }

    private static class Item {
        private TreeNode node;
        private int level;

        public Item(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    private void helper(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        int curLevelSum = levels.getOrDefault(level, 0);
        curLevelSum = curLevelSum + node.val;
        levels.put(level, curLevelSum);
        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }
}
