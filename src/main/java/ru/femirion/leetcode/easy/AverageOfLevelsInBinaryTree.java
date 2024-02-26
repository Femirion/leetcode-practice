package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.*;

/**
 * 637. Average of Levels in Binary Tree
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 */
public class AverageOfLevelsInBinaryTree {

    private TreeMap<Integer, List<Integer>> levels = new TreeMap<>();

    /**
     * Runtime 5 ms Beats 9.38% of users with Java
     * Memory 45.24 MB Beats 93.12% of users with Java
     */
    public List<Double> averageOfLevels(TreeNode root) {
        fillLevelsMap(root, 0);

        List<Double> result = new ArrayList<>();
        for (List<Integer> level : levels.values()) {
            long sum = 0;
            for (int e : level) {
                sum = sum + e;
            }
            result.add((double) sum / level.size());
        }
        return result;
    }

    private void fillLevelsMap(TreeNode node, int currentLevel) {
        if (node == null) {
            return;
        }

        List<Integer> nums = levels.getOrDefault(currentLevel, new ArrayList<>());
        nums.add(node.val);
        levels.put(currentLevel, nums);

        if (node.left == null && node.right == null) {
            return;
        }

        fillLevelsMap(node.left, currentLevel + 1);
        fillLevelsMap(node.right, currentLevel + 1);
    }
}
