package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. Balance a Binary Search Tree
 * https://leetcode.com/problems/balance-a-binary-search-tree/description/
 */
public class BalanceABinarySearchTree {


    List<Integer> elements = new ArrayList<>();

    /**
     * Runtime 2 ms Beats 96.45%
     * Memory 47.32 MB Beats 5.65%
     */
    public TreeNode balanceBST(TreeNode root) {
        collectElements(root);
        TreeNode newRoot = new TreeNode();
        combineNewTree(0, elements.size() - 1, newRoot);
        return newRoot;
    }

    private void collectElements(TreeNode node) {
        var x = elements;
        if (node == null) {
            return;
        }
        collectElements(node.left);
        elements.add(node.val);
        collectElements(node.right);
    }

    private TreeNode combineNewTree(int start, int end, TreeNode node) {
        var x = elements;
        int curIdx = start + (end - start) / 2;
        if (end < start) {
            return null;
        }
        node.val = elements.get(curIdx);
        node.left = combineNewTree(start, curIdx - 1, new TreeNode());
        node.right = combineNewTree(curIdx + 1, end, new TreeNode());
        return node;
    }
}
