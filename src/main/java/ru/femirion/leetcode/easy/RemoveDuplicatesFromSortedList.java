package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * Runtime 2 ms Beats 5.02% of users with Java
     * Memory 44.10 MB Beats 46.93% of users with Java
     */
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> nums = new HashSet<>();

        ListNode current = head;
        ListNode prev = head;

        while (current != null) {
            int val = current.val;
            if (nums.contains(val)) {
                prev.next = current.next;
            } else {
                nums.add(val);
                prev = current;
            }
            current = current.next;
        }
        return head;
    }

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 43.62 MB Beats 92.76% of users with Java
     */
    public ListNode deleteDuplicates1(ListNode head) {
        int[] arr = new int[201];

        ListNode current = head;
        ListNode prev = head;

        while (current != null) {
            int val = current.val;
            if (arr[val + 100] == 1) {
                prev.next = current.next;
            } else {
                arr[val + 100] = 1;
                prev = current;
            }
            current = current.next;
        }
        return head;
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
