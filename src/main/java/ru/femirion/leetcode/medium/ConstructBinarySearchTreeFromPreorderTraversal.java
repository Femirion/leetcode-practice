package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.Stack;

/**
 * 1008. Construct Binary Search Tree from Preorder Traversal
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

    private Stack<TreeNode> nodes = new Stack<>();
    private TreeNode head;

    /**
     * Runtime 1 ms Beats 16.30%
     * Memory 41.77 MB Beats 33.05%
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        head = new TreeNode(preorder[0]);
        nodes.push(head);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);

            TreeNode top = nodes.peek();
            while (!nodes.isEmpty() && nodes.peek().val < node.val) {
                top = nodes.pop();
            }


            if (top.val < node.val) {
                top.right = node;
            } else {
                top.left = node;
            }

            nodes.push(node);
        }

        return head;
    }
}
