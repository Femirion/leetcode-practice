package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.*;

/**
 * 894. All Possible Full Binary Trees
 * https://leetcode.com/problems/all-possible-full-binary-trees/description/
 */
public class AllPossibleFullBinaryTrees {

    Map<Integer, List<TreeNode>> cache = new HashMap<>();
    Set<String> existedResult = new HashSet<>();

    /**
     * Runtime 63 ms Beats 5.41%
     * Memory 52.86 MB Beats 5.27%
     */
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(new TreeNode());
        cache.put(1, nodeList);

        for (int i = 2; i <= n; i++) {
            var x = cache;
            List<TreeNode> nodes = cache.get(i - 1);
            List<TreeNode> generatedNodes = new ArrayList<>();
            for (TreeNode node : nodes) {
                List<Byte> directions = new ArrayList<>();
                generate(generatedNodes, directions, node, node);
            }
            i++;
            cache.put(i, generatedNodes);
        }

        return cache.get(n);
    }

    private void generate(List<TreeNode> result, List<Byte> directions, TreeNode root, TreeNode cur) {
        if (cur.left == null && cur.right == null) {
            TreeNode copiedRoot = deepCopy(root);
            TreeNode tmpNode = findNode(copiedRoot, 0, directions);
            tmpNode.left = new TreeNode();
            tmpNode.right = new TreeNode();
            var x = toString(copiedRoot);
            if (!existedResult.contains(x)) {
                result.add(copiedRoot);
                existedResult.add(x);
            }
            return;
        }
        if (cur.left != null) {
            directions.add((byte) 0);
            generate(result, directions, root, cur.left);
            directions.remove((Integer) directions.size() - 1);
        }
        if (cur.right != null) {
            directions.add((byte) 1);
            generate(result, directions, root, cur.right);
            directions.remove((Integer) directions.size() - 1);
        }
    }

    private TreeNode findNode(TreeNode node, int curIdx, List<Byte> directions) {
        var d = directions;
        if (curIdx == directions.size()) {
            return node;
        }
        if (directions.get((Integer) curIdx) == 0) {
            return findNode(node.left, curIdx + 1, directions);
        } else {
            return findNode(node.right, curIdx + 1, directions);
        }
    }

    private TreeNode deepCopy(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode copiedNode = new TreeNode();
        copiedNode.val = node.val;
        copiedNode.left = deepCopy(node.left);
        copiedNode.right = deepCopy(node.right);
        return copiedNode;
    }

    private String toString(TreeNode node) {
        if (node == null) {
            return null;
        }
        String str = node.val + " [" + toString(node.left) + "] -[" + toString(node.right) + "]";
        return str;
    }
}
