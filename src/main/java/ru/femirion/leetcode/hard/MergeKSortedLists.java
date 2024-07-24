package ru.femirion.leetcode.hard;

import ru.femirion.leetcode.utils.ListNode;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class MergeKSortedLists {

    /**
     * Runtime 142 ms Beats 7.10%
     * Memory 44.30 MB Beats 46.22%
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode headResult = result;
        ListNode curResult = new ListNode();


        while(true) {
            int min = Integer.MAX_VALUE;
            ListNode tmp = null;
            int minIdx = 0;
            for (int i = 0; i < lists.length; i++) {
                ListNode cur = lists[i];
                if (cur != null) {
                    if (cur.val < min) {
                        min = cur.val;
                        tmp = cur;
                        minIdx = i;
                    }
                }
            }
            if (tmp == null) {
                break;
            }
            ListNode movingList = lists[minIdx];
            movingList = movingList.next;
            lists[minIdx] = movingList;
            curResult = tmp;
            headResult.next = curResult;
            headResult = curResult;
        }

        return result.next;
    }
}
