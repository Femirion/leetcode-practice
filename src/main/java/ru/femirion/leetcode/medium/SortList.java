package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ListNode;

/**
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/description/
 */
public class SortList {

    /**
     * Runtime 1638 ms Beats 5.38%
     * Memory 56.41 MB Beats 68.72%
     */
    public ListNode sortList(ListNode head) {
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
