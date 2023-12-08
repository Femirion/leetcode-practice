package ru.femirion.leetcode.easy;

/**
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {

    /**
     * Runtime 1ms Beats 92.63% of users with Java
     * Memory 45.20MB Beats 27.46% of users with Java
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(-1, head);

        ListNode prev = first;
        ListNode current = head;

        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return first.next;
    }

     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
