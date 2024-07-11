package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/description/
 */
public class Subsets {

    /**
     * Runtime 2 ms Beats 52.02%
     * Memory 43.04 MB Beats 7.40%
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generate(result, new ArrayList<>(), new HashSet<>(), nums);
        return result;
    }

    private void generate(List<List<Integer>> result, List<Integer> tmpList, Set<Integer> existedElements, int[] nums) {
        if (tmpList.size() == nums.length) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        result.add(new ArrayList<>(tmpList));
        for (int i = 0; i < nums.length; i++) {
            if (existedElements.contains(nums[i])) {
                continue;
            }
            if (!tmpList.isEmpty() && nums[i] < tmpList.get(tmpList.size() - 1) ) {
                continue;
            }
            tmpList.add(nums[i]);
            existedElements.add(nums[i]);
            generate(result, tmpList, existedElements, nums);
            tmpList.remove((Integer) nums[i]);
            existedElements.remove(nums[i]);
        }
    }
}
