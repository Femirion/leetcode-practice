package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ImmutableListNode;

/**
 * 1265. Print Immutable Linked List in Reverse
 * https://leetcode.com/problems/print-immutable-linked-list-in-reverse/description/
 */
public class PrintImmutableLinkedListInReverse {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.79 MB Beats 90.46%
     */
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) {
            return;
        }
        ImmutableListNode next = head.getNext();
        if (next == null) {
            head.printValue();
        } else {
            printLinkedListInReverse(next);
            head.printValue();
        }
    }
}
