package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ListNode;

/**
 * 328. Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/description/
 */
public class OddEvenLinkedList {

    /**
     * Runtime 1 ms Beats 13.58% of users with Java
     * Memory 43.96 MB Beats 97.12% of users with Java
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode tmpOdd = odd;
        ListNode tmpEven = even;
        ListNode result;
        int i = 0;

        while (head != null) {
            if (i % 2 == 0) {
                tmpOdd.next = new ListNode(head.val);
                tmpOdd = tmpOdd.next;
            } else {
                tmpEven.next = new ListNode(head.val);
                tmpEven = tmpEven.next;
            }
            head = head.next;
            i++;
        }
        result = odd.next;
        while (odd.next != null) {
            odd = odd.next;
        }
        odd.next = even.next;
        return result;
    }
}
