package ru.femirion.leetcode.medium;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class KthLargestElementInAnArray {

    /**
     * Runtime 42 ms Beats 60.03% of users with Java
     * Memory 56.94 MB Beats 79.78% of users with Java
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (heap.size() == k) {
                int min = heap.peek();
                if (min < nums[i]) {
                    heap.remove();
                    heap.add(nums[i]);
                }
            } else {
                heap.add(nums[i]);
            }
        }
        return heap.size() > 0 ? heap.peek() : 0;
    }
}
