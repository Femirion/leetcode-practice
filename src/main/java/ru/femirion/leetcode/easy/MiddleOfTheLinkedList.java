package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfTheLinkedList {

    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 40.59MB Beats 8.60% of users with Java
     */
    public ListNode middleNode(ListNode head) {
        ListNode fake = new ListNode(0, head);
        ListNode p = fake;
        ListNode q = fake;

        while (q != null) {
            if (q.next != null) {
                q = q.next;
            } else {
                return p.next;
            }
            if (q.next != null) {
                q = q.next;
            } else {
                return p.next;
            }
            p = p.next;
        }
        return p;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            List<Integer> values = new ArrayList<>();
            ListNode tmp = next;
            while (tmp != null) {
                values.add(tmp.val);
                tmp = tmp.next;
            }
            return values.toString();
        }
    }

}
