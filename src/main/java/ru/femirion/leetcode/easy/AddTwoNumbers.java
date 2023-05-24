package ru.femirion.leetcode.easy;

/*
https://leetcode.com/problems/two-sum/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.*/
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
