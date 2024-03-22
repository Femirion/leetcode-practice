package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1469. Find All The Lonely Nodes
 * https://leetcode.com/problems/find-all-the-lonely-nodes/description/
 *
 * #Tree
 */
public class FindAllTheLonelyNodes {

    private List<Integer> values = new ArrayList<>();

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 44.26 MB Beats 92.19% of users with Java
     */
    public List<Integer> getLonelyNodes(TreeNode root) {
        searchAllLonelyNodes(root);
        return values;
    }

    private void searchAllLonelyNodes(TreeNode node) {
        if (node == null) {
            return;
        }

        var t = node.val;

        if (node.left != null && node.right == null) {
            values.add(node.left.val);
            searchAllLonelyNodes(node.left);
        }

        if (node.left == null && node.right != null) {
            values.add(node.right.val);
            searchAllLonelyNodes(node.right);
        }

        if (node.left != null && node.right != null) {
            searchAllLonelyNodes(node.left);
            searchAllLonelyNodes(node.right);
        }
    }
}
