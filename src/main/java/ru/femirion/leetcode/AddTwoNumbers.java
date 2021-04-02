package ru.femirion.leetcode;


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int shouldAddFromPrevStep = 0;
        ListNode ret = new ListNode();
        ListNode curr = ret;

        while (l1 != null || l2 != null) {
            int v1;
            int v2;

            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            } else {
                v1 = 0;
            }

            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            } else {
                v2 = 0;
            }

            int sum = v1 + v2 + shouldAddFromPrevStep;
            // for example 9 + 8 sum should be equals 7 and shouldAddFromPrevStep equals 1
            if (sum > 9) {
                sum = sum - 10;
                shouldAddFromPrevStep = 1;
            } else {
                shouldAddFromPrevStep = 0;
            }

            curr.next = new ListNode(sum);
            curr = curr.next;
        }
        if (shouldAddFromPrevStep != 0) {
            curr.next = new ListNode(shouldAddFromPrevStep);
        }
        return ret.next;
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
