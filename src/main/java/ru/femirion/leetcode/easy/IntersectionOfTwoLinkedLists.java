package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * 5ms Beats 25.61%of users with Java
     * 46.36MB Beats 82.48%of users with Java
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();
        while (true) {
            nodes.add(headA);
            if (headA.next == null) {
                break;
            }
            headA = headA.next;
        }

        while (true) {
            if (nodes.contains(headB)) {
                return headB;
            }
            if (headB.next == null) {
                break;
            }
            headB = headB.next;
        }

        return null;
    }

    /**
     * 1ms Beats 99.05%of users with Java
     * 46.36MB Beats 82.48%of users with Java
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p =  (p != null) ? p.next : headB;
            q =  (q != null) ? q.next : headA;
        }
        return p;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
