package ru.femirion.leetcode.medium;

/**
 * 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 */
public class DeleteNodeInALinkedList {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 43.79 MB Beats 72.16% of users with Java
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
