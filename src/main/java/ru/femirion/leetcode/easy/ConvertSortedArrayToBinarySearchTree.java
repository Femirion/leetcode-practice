package ru.femirion.leetcode.easy;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * 0ms Beats 100.00%of users with Java
     * 42.94MB Beats 81.19% of users with Java
     * 42.65MB Beats 97.83%of users with Java with short instead int
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return createBinarySearchTree(nums, (short) 0, (short) (nums.length - 1));

    }

    private TreeNode createBinarySearchTree(int[] nums, short startIdx, short endIdx) {
        if (startIdx > endIdx) {
            return null;
        }
        short mid = (short) ((startIdx + endIdx) / 2);

        TreeNode node = new TreeNode(nums[mid]);
        node.left = createBinarySearchTree(nums, startIdx, (short) (mid - 1));
        node.right = createBinarySearchTree(nums,(short) (mid + 1), endIdx);
        return node;
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
