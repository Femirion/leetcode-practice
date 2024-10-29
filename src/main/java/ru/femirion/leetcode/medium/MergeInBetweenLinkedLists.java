package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ListNode;

/**
 * 1669. Merge In Between Linked Lists
 * https://leetcode.com/problems/merge-in-between-linked-lists/description/
 */
public class MergeInBetweenLinkedLists {

    /**
     * Runtime 1 ms Beats 100.00%
     * Memory 46.49 MB Beats 41.83%
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int p = 1;
        ListNode head = list1;
        ListNode tmp = list1;
        while (p < a) {
            tmp = tmp.next;
            p++;
        }

        ListNode insertPlace = tmp;

        while (p <= b) {
            tmp = tmp.next;
            p++;
        }

        tmp = tmp.next;

        insertPlace.next = list2;

        while (insertPlace.next != null) {
            insertPlace = insertPlace.next;
        }

        insertPlace.next = tmp;


        return head;
    }
}
