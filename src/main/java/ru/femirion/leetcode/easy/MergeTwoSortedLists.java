package ru.femirion.leetcode.easy;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        while (list1.next != null || list2.next != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 >= val2) {
                result = list1;
            }


        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
