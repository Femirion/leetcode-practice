package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2196. Create Binary Tree From Descriptions
 * https://leetcode.com/problems/create-binary-tree-from-descriptions/description/
 */
public class CreateBinaryTreeFromDescriptions {

    /**
     * Runtime 86 ms Beats 16.92%
     * Memory 56.72 MB Beats 13.75%
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> posibleHeads = new HashSet<>();
        Set<Integer> notHeads = new HashSet<>();

        for (int[] arr : descriptions) {
            TreeNode cur = nodes.getOrDefault(arr[0], new TreeNode(arr[0]));
            TreeNode child = nodes.getOrDefault(arr[1], new TreeNode(arr[1]));
            if (arr[2] == 0) {
                cur.right = child;
            } else {
                cur.left = child;
            }
            nodes.put(arr[0], cur);
            nodes.put(arr[1], child);
            notHeads.add(arr[1]);
            posibleHeads.add(arr[0]);
        }

        TreeNode head = null;
        for (int headValue : posibleHeads) {
            if (!notHeads.contains(headValue)) {
                head = nodes.get(headValue);
                break;
            }
        }

        return head;
    }
}
