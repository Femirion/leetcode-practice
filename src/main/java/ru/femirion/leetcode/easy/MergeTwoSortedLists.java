package ru.femirion.leetcode.easy;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLists {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 42.40 MB Beats 50.28% of users with Java
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        int val1;
        int val2;
        ListNode mergedList = new ListNode();
        ListNode result = mergedList;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                val1 = Integer.MAX_VALUE;
            } else {
                val1 = list1.val;
            }
            if (list2 == null) {
                val2 = Integer.MAX_VALUE;
            } else {
                val2 = list2.val;
            }

            if (val1 <= val2) {
                mergedList.next = list1;
                list1 = list1.next;
            } else {
                mergedList.next = list2;
                list2 = list2.next;
            }
            mergedList = mergedList.next;
        }
        return result.next;
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
