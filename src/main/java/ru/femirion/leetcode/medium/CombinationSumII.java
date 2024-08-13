package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/description/
 */
public class CombinationSumII {

    /**
     * Runtime 3 ms Beats 82.44%
     * Memory 43.23 MB Beats 37.68%
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        generate(result, new ArrayList<>(), 0, candidates, 0, target);
        return result;
    }

    private void generate(List<List<Integer>> result, List<Integer> tmpResult, int tmpSum, int[] candidates, int startIdx, int target) {
        if (tmpSum == target) {
            result.add(new ArrayList<>(tmpResult));
            return;
        }
        for (int i = startIdx; i < candidates.length; i++) {
            if (startIdx < i && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (tmpSum + candidates[i] <= target) {
                tmpResult.add(candidates[i]);
                generate(result, tmpResult, tmpSum + candidates[i], candidates, i + 1, target);
                tmpResult.remove((Integer) tmpResult.size() - 1);
            } else {
                break;
            }
        }
    }
}
