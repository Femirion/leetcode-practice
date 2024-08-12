package ru.femirion.leetcode.easy;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 */
public class KthLargestElementInAStream {

    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int k;

    /**
     * Runtime 14 ms Beats 51.46%
     * Memory 46.97 MB Beats 46.12%
     */
    public KthLargestElementInAStream(int k, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (k <= i) {
                queue.remove();
            }
        }
        this.k = k;
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (val > queue.peek()) {
            queue.offer(val);
            queue.remove();
        }
        return queue.peek();
    }
}
