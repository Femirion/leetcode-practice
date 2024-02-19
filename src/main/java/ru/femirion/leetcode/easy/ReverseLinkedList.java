package ru.femirion.leetcode.easy;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseLinkedList {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 42.08 MB Beats 92.52% of users with Java
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        if (current == null) {
            return head;
        }

        ListNode next = current.next;

        while (current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }
        return current;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
