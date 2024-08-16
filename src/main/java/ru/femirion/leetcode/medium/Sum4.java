package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/description/
 */
public class Sum4 {

    /**
     * Runtime 2580 ms Beats 5.01%
     * Memory 45.48 MB Beats 15.89%
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generate(result, new ArrayList<>(), 0, 0, 0, nums, target);
        return result;
    }

    private void generate(List<List<Integer>> result, List<Integer> tmp, long curSum, int count, int idx, int[] nums, int target) {
        if (curSum == target && count == 4) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        if (count == 4) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (idx < i && nums[i] == nums[i - 1]) {
                continue;
            }
            if (0 < target && target < curSum + nums[i]) {
                return;
            }
            tmp.add(nums[i]);
            generate(result, tmp, curSum + nums[i], count + 1, i + 1, nums, target);
            tmp.remove((Integer) tmp.size() - 1);
        }
    }
}
