package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * #Tree
 */
public class BinaryTreeInorderTraversal {

    private List<Integer> result = new ArrayList<>();

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.74 MB Beats 14.70% of users with Java
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur.left);
                cur = cur.left;
            }

            TreeNode top = stack.pop();
            result.add(top.val);
            cur = top.right;
        }
        return result;
    }


    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.34 MB Beats 75.16% of users with Java
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        passThroughTree(root);
        return result;
    }

    private void passThroughTree(TreeNode node) {
        if (node == null) {
            return;
        }

        passThroughTree(node.left);
        result.add(node.val);
        passThroughTree(node.right);
    }
}
