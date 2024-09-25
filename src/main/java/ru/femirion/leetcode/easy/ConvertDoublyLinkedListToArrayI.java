package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 3263. Convert Doubly Linked List to Array I
 * https://leetcode.com/problems/convert-doubly-linked-list-to-array-i/description/
 */
public class ConvertDoublyLinkedListToArrayI {

    /**
     * Runtime 6 ms Beats 6.87%
     * Memory 45.22 MB Beats 6.53%
     */
    public int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list.stream().mapToInt(e -> e).toArray();
    }
}
