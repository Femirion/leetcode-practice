package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 * https://leetcode.com/problems/leaf-similar-trees/description/
 */
public class LeafSimilarTrees {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.30 MB Beats 60.95% of users with Java
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        fillLeaves(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        fillLeaves(root2, list2);

        return root1.equals(root2);
    }

    private void fillLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }

        fillLeaves(root.left, leaves);
        fillLeaves(root.right, leaves);
    }
}
