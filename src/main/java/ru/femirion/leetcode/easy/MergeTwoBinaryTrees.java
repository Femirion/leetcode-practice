package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 617. Merge Two Binary Trees
 * https://leetcode.com/problems/merge-two-binary-trees/description/
 *
 * #Tree
 */
public class MergeTwoBinaryTrees {

    /**
     * Runtime 0 ms Beat 100.00% of users with Java
     * Memory 43.98 MB Beats 99.69% of users with Java
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    private TreeNode merge(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            node2.val = node2.val + node1.val;
        }

        if (node1 == null || node2 == null) {
            if (node2 == null) {
                return node1;
            } else {
                return node2;
            }
        }

        if (node1.left != null && node2.left == null) {
            node2.left = node1.left;
        } else {
            if (node1.left != null) {
                merge(node1.left, node2.left);
            }
        }

        if (node1.right != null && node2.right == null) {
            node2.right = node1.right;
        } else {
            if (node1.right != null) {
                merge(node1.right, node2.right);
            }
        }
        return node2;
    }
}
