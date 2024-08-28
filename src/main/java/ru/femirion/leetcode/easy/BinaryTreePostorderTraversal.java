package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 */
public class BinaryTreePostorderTraversal {

    private List<Integer> result = new ArrayList<>();

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.46 MB Beats 70.12%
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        passTheTree(root);
        return result;
    }

    private void passTheTree(TreeNode node) {
        if (node == null) {
            return;
        }
        passTheTree(node.left);
        passTheTree(node.right);
        result.add(node.val);
    }
}
