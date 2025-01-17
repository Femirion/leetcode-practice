package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode();
        fake.next = head;

        ListNode pointer = fake;

        while (pointer != null) {
            ListNode first = pointer.next;
            if (first == null) {
                break;
            }
            ListNode second = first.next;
            if (second == null) {
                break;
            }
            pointer.next = second;
            ListNode tmp = second.next;
            second.next = first;
            first.next = tmp;
            pointer = first;
        }


        return fake.next;
    }
}
