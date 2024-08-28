package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 */
public class BinaryTreePreorderTraversal {

    private List<Integer> result = new ArrayList<>();

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.58 MB Beats 47.94%
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        passTheTree(root);
        return result;
    }

    private void passTheTree(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        passTheTree(root.left);
        passTheTree(root.right);
    }
}
