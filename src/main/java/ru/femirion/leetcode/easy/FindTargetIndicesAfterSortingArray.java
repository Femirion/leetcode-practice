package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2089. Find Target Indices After Sorting Array
 * https://leetcode.com/problems/find-target-indices-after-sorting-array/description/
 */
public class FindTargetIndicesAfterSortingArray {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 43.03 MB Beats 53.90% of users with Java
     */
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();

        int count = 0;
        int countOfLessElements = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                continue;
            }
            if (nums[i] < target) {
                countOfLessElements++;
            }
        }

        for (int i = 0; i < count; i++) {
            result.add(i + countOfLessElements);
        }

        return result;
    }
}
