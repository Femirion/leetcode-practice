package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ListNode;

/**
 * 147. Insertion Sort List
 * https://leetcode.com/problems/insertion-sort-list/description/
 */
public class InsertionSortList {

    /**
     * Runtime 3 ms Beats 96.70%
     * Memory 44.22 MB Beats 71.69%
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode tmp = head;

        while (tmp != null) {
            if (tmp.next != null && tmp.next.val < tmp.val) {
                ListNode forInsert = tmp.next;
                ListNode next = forInsert.next;
                if (forInsert.val < head.val) {
                    forInsert.next = head;
                    head = forInsert;
                    tmp.next = next;
                } else {
                    ListNode beforeInsert = head;
                    ListNode afterInsert = head.next;
                    while (afterInsert.val < tmp.next.val) {
                        beforeInsert = afterInsert;
                        afterInsert = afterInsert.next;
                    }
                    beforeInsert.next = forInsert;
                    forInsert.next = afterInsert;
                    tmp.next = next;
                }
            } else {
                tmp = tmp.next;
            }
        }

        return head;
    }
}
