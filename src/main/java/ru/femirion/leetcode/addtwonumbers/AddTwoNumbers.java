package ru.femirion.leetcode.addtwonumbers;

public class AddTwoNumbers {
    public static void main(String[] args) {
        // Input: l1 = [2,4,3], l2 = [5,6,4]
        // Output: [7,0,8]
        ListNode l13 = new ListNode(3, null);
        ListNode l12 = new ListNode(4, l13);
        ListNode l11 = new ListNode(2, l12);

        ListNode l23 = new ListNode(4, null);
        ListNode l22 = new ListNode(6, l23);
        ListNode l21 = new ListNode(5, l22);

        var solution = new Solution();
        var result = solution.addTwoNumbers(l11, l21);
        System.out.println(result);
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int shouldAddFromPrevStep = 0;
            ListNode prev = new ListNode();

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
                if (sum > 9) {
                    sum = sum - 10;
                    shouldAddFromPrevStep = 1;
                } else {
                    shouldAddFromPrevStep = 0;
                }

                ListNode current = new ListNode(sum, prev);
                prev = current;
            }

            return prev;
        }
    }

    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
