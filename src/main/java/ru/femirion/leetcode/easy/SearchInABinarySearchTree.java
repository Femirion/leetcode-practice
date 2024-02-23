package ru.femirion.leetcode.easy;

/**
 * 700. Search in a Binary Search Tree
 * https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 */
public class SearchInABinarySearchTree {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 45.62 MB Beats 7.22% of users with Java
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }
}
