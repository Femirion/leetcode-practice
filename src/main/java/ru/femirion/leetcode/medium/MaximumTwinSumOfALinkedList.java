package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2130. Maximum Twin Sum of a Linked List
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
 */
public class MaximumTwinSumOfALinkedList {

    /**
     * Runtime 4 ms Beats 97.87% of users with Java
     * Memory 63.40 MB Beats 67.55% of users with Java
     */
    public int pairSum1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        int count = 0;
        while (fast != null) {
            count = count + 1;
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        int i = 0;
        while (i < count) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
            i++;
        }

        int max = 0;
        int tmp;
        while (slow != null) {
            tmp = slow.val + cur.val;
            if (tmp > max) {
                max = tmp;
            }
            slow = slow.next;
            cur = cur.next;
        }
        return max;
    }

    /**
     * Runtime 11 ms Beats 29.92% of users with Java
     * Memory 65.02 MB Beats 29.25% of users with Java
     */
    public int pairSum(ListNode head) {
        List<Integer> values = new ArrayList<>();

        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int max = 0;
        int p = 0;
        int q = values.size() - 1;
        int curSum;

        while (p < q) {
            curSum = values.get(p) + values.get(q);
            if (curSum > max) {
                max = curSum;
            }
            p++;
            q--;
        }

        return max;
    }
}
