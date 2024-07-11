package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations {

    /**
     * Runtime 2 ms Beats 42.22%
     * Memory 44.46 MB Beats 37.04%
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(result, new ArrayList<>(), new HashSet<>(), nums);
        return result;
    }

    private void generate(List<List<Integer>> result, List<Integer> tmpList, Set<Integer> existedNums, int[] nums) {
        if (tmpList.size() == nums.length) {
            result.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (existedNums.contains(cur)) {
                continue;
            }
            tmpList.add(cur);
            existedNums.add(cur);
            generate(result, tmpList, existedNums, nums);
            tmpList.remove((Integer) cur);
            existedNums.remove(cur);
        }
    }



}
