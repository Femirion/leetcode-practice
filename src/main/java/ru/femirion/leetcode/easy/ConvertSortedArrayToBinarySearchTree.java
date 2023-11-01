package ru.femirion.leetcode.easy;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced
 *  binary search tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
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
