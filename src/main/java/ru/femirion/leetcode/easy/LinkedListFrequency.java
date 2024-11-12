package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3063. Linked List Frequency
 * https://leetcode.com/problems/linked-list-frequency/description/
 */
public class LinkedListFrequency {

    /**
     * Runtime 37 ms Beats 25.42%
     * Memory 55.86 MB Beats 94.34%
     */
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> counterMap = new HashMap<>();

        while (head != null) {
            int value = head.val;
            counterMap.put(value, counterMap.getOrDefault(value, 0) + 1);
            head = head.next;
        }

        ListNode result = new ListNode();
        ListNode tmp = result;
        int size = 0;
        for (Map.Entry<Integer, Integer> e : counterMap.entrySet()) {
            tmp.val = e.getValue();
            if (size < counterMap.size() - 1) {
                ListNode next = new ListNode();
                tmp.next = next;
                tmp = next;
            }
            size++;
        }

        return result;
    }
}
