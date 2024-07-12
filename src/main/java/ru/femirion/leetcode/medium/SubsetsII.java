package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/description/
 */
public class SubsetsII {

    /**
     * Runtime 1 ms Beats 99.92%
     * Memory 43.17 MB Beats 82.04%
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generate(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void generate(List<List<Integer>> result, List<Integer> tmpList, int[] nums, int start) {
        result.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tmpList.add(nums[i]);
            generate(result, tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
