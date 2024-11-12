package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class BinaryTreeRightSideView {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.97 MB Beats 63.82%
     */
    private List<Integer> levels = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (levels.size() <= level) {
            levels.add(node.val);
        }
        helper(node.right, level + 1);
        helper(node.left, level + 1);
    }
}
