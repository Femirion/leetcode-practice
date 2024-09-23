package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ListNode;

/**
 * 2807. Insert Greatest Common Divisors in Linked List
 * https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/
 */
public class InsertGreatestCommonDivisorsInLinkedList {

    /**
     * Runtime 2 ms Beats 65.97%
     * Memory 45.39 MB Beats 9.45%
     */
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        passTheList(head);
        return head;
    }

    private void passTheList(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        int left = node.val;
        int right = node.next.val;
        int divisior = getGreatestCommonDivisors(left, right);
        ListNode next = node.next;
        ListNode newNode = new ListNode(divisior);
        node.next = newNode;
        newNode.next = next;
        passTheList(next);
    }

    private int getGreatestCommonDivisors(int left, int right) {
        while(right != 0){
            int temp = right;
            right = left % right;
            left = temp;
        }

        return left;
    }
}
