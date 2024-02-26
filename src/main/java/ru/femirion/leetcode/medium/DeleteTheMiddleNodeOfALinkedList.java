package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ListNode;

/**
 * 2095. Delete the Middle Node of a Linked List
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
 */
public class DeleteTheMiddleNodeOfALinkedList {

    /**
     * Runtime 3 ms Beats 99.87% of users with Java
     * Memory 65.41 MB Beats 15.03% of users with Java
     */
    public ListNode deleteMiddle(ListNode head) {
        ListNode fake = new ListNode(0, head);

        ListNode quick = fake;
        ListNode slow = fake;
        ListNode prev = fake;

        while(quick != null) {
            quick = quick.next;
            if (quick == null) {
                prev = slow;
                slow = slow.next;
                break;
            }
            quick = quick.next;
            prev = slow;
            slow = slow.next;
        }


        prev.next = slow.next;
        return head;
    }
}
