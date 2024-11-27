package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 366. Find Leaves of Binary Tree
 * https://leetcode.com/problems/find-leaves-of-binary-tree/description/
 */
public class FindLeavesOfBinaryTree {

    Map<Integer, List<Integer>> nodes = new HashMap<>();

    List<List<Integer>> result = new ArrayList<>();

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.91 MB Beats 22.99%
     */
    public List<List<Integer>> findLeaves2(TreeNode root) {
        countDeep2(root);
        return result;
    }

    int countDeep2(TreeNode node) {
        var x = result;
        if (node == null) {
            return -1;
        }

        int leftDeep = countDeep(node.left);
        int rightDeep = countDeep(node.right);

        int curMaxLevel = Math.max(leftDeep, rightDeep) + 1;

        if (result.size() <= curMaxLevel) {
            List<Integer> newLevelNodes = new ArrayList();
            result.add(newLevelNodes);
            newLevelNodes.add(node.val);
        } else {
            result.get(curMaxLevel).add(node.val);
        }

        return curMaxLevel;
    }

    /**
     * Runtime 3 ms Beats 6.43%
     * Memory 42.00 MB Beats 22.99%
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        countDeep(root);

        List<List<Integer>> result = nodes.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e1.getKey(), e2.getKey()))
                .map(e -> e.getValue())
                .collect(Collectors.toList());

        return result;
    }

    int countDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDeep = countDeep(node.left);
        int rightDeep = countDeep(node.right);

        int curMaxLevel = Math.max(leftDeep, rightDeep) + 1;

        List<Integer> curLevelNodes = nodes.getOrDefault(curMaxLevel, new ArrayList<>());
        curLevelNodes.add(node.val);
        nodes.put(curMaxLevel, curLevelNodes);

        return curMaxLevel;
    }
}
