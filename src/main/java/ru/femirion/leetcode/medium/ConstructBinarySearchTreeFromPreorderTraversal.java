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

    private int curIdx = 0;

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 42.05 MB Beats 7.76%
     */
    public TreeNode bstFromPreorder2(int[] preorder) {
        return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] preorder, int min, int max) {
        if (curIdx == preorder.length) {
            return null;
        }
        int curVal = preorder[curIdx];
        if (curVal < min || max < curVal) {
            return null;
        }

        curIdx++;
        TreeNode node = new TreeNode(curVal);
        node.left = buildTree(preorder, min, curVal);
        node.right = buildTree(preorder, curVal, max);
        return node;
    }
}
