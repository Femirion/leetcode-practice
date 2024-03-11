package ru.femirion.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 28. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
public class LongestConsecutiveSequence {

    /**
     * Runtime 36 ms Beats 48.23% of users with Java
     * Memory 57.24 MB Beats 73.10% of users with Java
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = 1;
        Set<Integer> set = new HashSet<>();

        for (int e : nums) {
            set.add(e);
        }

        int next;
        int prev;
        int cur;
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            tmp = 1;
            cur = nums[i];
            next = cur + 1;
            prev = cur - 1;

            while (set.contains(next)) {
                tmp++;
                set.remove(next);
                next++;
            }

            while (set.contains(prev)) {
                tmp++;
                set.remove(prev);
                prev--;
            }

            set.remove(cur);
            if (tmp > max) {
                max = tmp;
            }
        }

        return max;
    }
}
