package ru.femirion.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 922. Sort Array By Parity II
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 */
public class SortArrayByParityII {

    /**
     * Runtime 22ms Beats 5.18% of users with Java
     * Memory 45.27MB Beats 22.75% of users with Java
     */
    public int[] sortArrayByParityII(int[] nums) {
        PriorityQueue<Integer> oddQueue = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> evenQueue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenQueue.offer(nums[i]);
            } else {
                oddQueue.offer(nums[i]);
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = evenQueue.remove();
            } else {
                result[i] = oddQueue.remove();
            }
        }
        return result;
    }

    /**
     * Runtime 3ms Beats 45.62% of users with Java
     * Memory 46.38MB Beats 5.90% of users with Java
     */
    public int[] sortArrayByParityII1(int[] nums) {
        int[] oddQueue = new int[nums.length/2];
        int[] evenQueue = new int[nums.length/2];

        int oddPointer = 0;
        int evenPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenQueue[evenPointer] = nums[i];
                evenPointer++;
            } else {
                oddQueue[oddPointer] = nums[i];
                oddPointer++;
            }
        }

        oddPointer = 0;
        evenPointer = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = evenQueue[evenPointer];
                evenPointer++;
            } else {
                result[i] = oddQueue[oddPointer];
                oddPointer++;
            }
        }
        return result;
    }

    /**
     * Runtime 6ms Beats 18.58% of users with Java
     * Memory 44.80MB Beats 72.19% of users with Java
     */
    public int[] sortArrayByParityII2(int[] nums) {
        int[] result = new int[nums.length];

        Arrays.sort(nums);
        int evenPointer = 0;
        int oddPointer = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[evenPointer] = nums[i];
                evenPointer = evenPointer + 2;
            } else {
                result[oddPointer] = nums[i];
                oddPointer = oddPointer + 2;
            }
        }
        return result;
    }

}
