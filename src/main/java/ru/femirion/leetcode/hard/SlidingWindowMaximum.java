package ru.femirion.leetcode.hard;

import java.util.PriorityQueue;

/**
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/description/
 */
public class SlidingWindowMaximum {

    /**
     * Runtime 77 ms Beats 15.14%
     * Memory 57.51 MB Beats 95.57%
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < k; i++) {
            queue.offer(new int[] {nums[i], i});
        }

        int[] result = new int[nums.length - k + 1];
        int resultIdx = 0;
        result[resultIdx] = queue.peek()[0];
        resultIdx++;

        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[] {nums[i], i});
            int[] arr = queue.peek();
            while (arr[1] < i - k + 1) {
                queue.poll();
                arr = queue.peek();
            }
            result[resultIdx] = arr[0];
            resultIdx++;
        }
        return result;
    }
}
