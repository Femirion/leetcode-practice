package ru.femirion.leetcode.easy;

import java.util.Collections;
import java.util.List;

/**
 * 2824. Count Pairs Whose Sum is Less than Target
 * https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/
 */
public class CountPairsWhoseSumIsLessThanTarget {

    /**
     * Runtime 3 ms Beats 39.50% of users with Java
     * Memory 42.31 MB Beats 37.24% of users with Java
     */
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);

        int p = 0;
        int q = findPosition(nums, target - nums.get(0));
        if (q == -1) {
            return 0;
        }
        int result = 0;
        while (p < q) {
            if (nums.get(p) + nums.get(q) < target) {
                result = result + (q - p);
                p++;
            } else {
                q--;
            }

        }
        return result;
    }

    private int findPosition(List<Integer> nums, int target) {
        int start = 0;
        int end = nums.size() - 1;
        int currentIxs = (end - start) / 2;
        int current;

        while (start < end) {
            if (end - start == 1) {
                if (nums.get(end) <= target) {
                    return end;
                }
                if (nums.get(start) <= target) {
                    return start;
                }
                return -1;
            }

            current = nums.get(currentIxs);
            if (current == target) {
                return currentIxs;
            }
            if (current > target) {
                end = currentIxs;
            } else {
                start = currentIxs;
            }
            currentIxs = start + ((end - start) / 2);
        }

        return -1;
    }
}
