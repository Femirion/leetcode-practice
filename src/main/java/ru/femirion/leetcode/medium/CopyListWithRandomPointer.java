package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */
public class CopyListWithRandomPointer {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 44.45 MB Beats 43.85%
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> nodes = new HashMap<>();

        Node tmpHead = head;
        Node newHead = new Node(0);
        Node tmpNewHead = newHead;
        while (tmpHead != null) {
            Node node = new Node(tmpHead.val);
            tmpNewHead.next = node;
            nodes.put(tmpHead, node);
            tmpHead = tmpHead.next;
            tmpNewHead = node;
        }

        tmpHead = head;
        tmpNewHead = newHead.next;
        while (tmpHead != null) {
            Node newRandom = nodes.get(tmpHead.random);
            tmpNewHead.random = newRandom;
            tmpNewHead = tmpNewHead.next;
            tmpHead = tmpHead.next;
        }

        return newHead.next;
    }
}
