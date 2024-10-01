package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.NodeN;

/**
 * 1490. Clone N-ary Tree
 * https://leetcode.com/problems/clone-n-ary-tree/description/
 */
public class CloneNAryTree {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 46.40 MB Beats 87.06%
     */
    public NodeN cloneTree(NodeN root) {
        return deepClone(root);
    }

    private NodeN deepClone(NodeN node) {
        if (node == null) {
            return null;
        }
        NodeN clonedNode = new NodeN();
        clonedNode.val = node.val;
        for (NodeN child : node.children) {
            NodeN clonedChild = deepClone(child);
            clonedNode.children.add(clonedChild);
        }
        return clonedNode;
    }
}
