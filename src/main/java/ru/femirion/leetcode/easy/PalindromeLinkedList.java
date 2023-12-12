package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

    /**
     * Runtime 8ms Beats 26.32% of users with Java
     * Memory 58.72MB Beats 35.80% of users with Java
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < nums.size()/2; i++) {
            if (! nums.get(i).equals(nums.get(nums.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
