package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.Node;

import java.util.ArrayDeque;

/**
 * 3294. Convert Doubly Linked List to Array II
 * https://leetcode.com/problems/convert-doubly-linked-list-to-array-ii/description/
 */
public class ConvertDoublyLinkedListToArrayII {

    /**
     * Runtime 3 ms Beats 42.55%
     * Memory 44.99 MB Beats 97.87%
     */
    public int[] toArray(Node node) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();

        if (node == null) {
            return new int[0];
        }

        Node startNode = node.next;
        while(node != null) {
            deq.addFirst(node.val);
            node = node.prev;
        }

        while(startNode != null) {
            deq.addLast(startNode.val);
            startNode = startNode.next;
        }

        int[] result = new int[deq.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = deq.removeFirst();
        }
        return result;
    }
}
