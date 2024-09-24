package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ListNode;

/**
 * 2181. Merge Nodes in Between Zeros
 * https://leetcode.com/problems/merge-nodes-in-between-zeros/description/
 */
public class MergeNodesInBetweenZeros {

    /**
     * Runtime 5 ms Beats 78.29%
     * Memory 82.21 MB Beats 35.44%
     */
    public ListNode mergeNodes(ListNode head) {
        ListNode first = new ListNode();
        ListNode cur = first;

        int curSum = 0;
        while(head != null) {
            if (head.val == 0) {
                if (0 < curSum) {
                    cur.next = new ListNode(curSum);
                    curSum = 0;
                    cur = cur.next;
                }
            } else {
                curSum = curSum + head.val;
            }
            head = head.next;
        }

        return first.next;
    }
}
