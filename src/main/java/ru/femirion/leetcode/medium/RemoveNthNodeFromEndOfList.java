package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.51 MB Beats 83.01%
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeNode = new ListNode();
        fakeNode.next = head;
        ListNode quick = fakeNode;
        ListNode slow = fakeNode;

        for (int i = 0; i <= n; i++) {
            quick = quick.next;
        }

        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return fakeNode.next;
    }
}
