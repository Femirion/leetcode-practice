package ru.femirion.leetcode.easy;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

    /**
     * Runtime 1ms Beats 22.31% of users with Java
     * Memory 43.69MB Beats 29.32% of users with Java
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p1 = head;
        if (p1.next != null) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p2 != null || p1 != null) {
            if (p2 == p1) {
                return true;
            }
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p1 != null && p1.next != null) {
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        return false;
    }

    /**
     * Definition for singly-linked list.
     **/
     public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
     }

}
