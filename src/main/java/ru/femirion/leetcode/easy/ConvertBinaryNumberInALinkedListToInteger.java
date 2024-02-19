package ru.femirion.leetcode.easy;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.82 MB Beats 78.26% of users with Java
     */
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(sb.toString(), 2);
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
