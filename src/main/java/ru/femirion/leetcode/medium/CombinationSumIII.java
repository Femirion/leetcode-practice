package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 * https://leetcode.com/problems/combination-sum-iii/description/
 */
public class CombinationSumIII {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 40.89 MB Beats 56.05%
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        int min = 0;
        for(int i = 1; i <= k; i++) {
            min = min + i;
        }
        int max = 0;
        for (int i = 9; 9 - k <= i; i--) {
            max = max + i;
        }
        if (n < min || max < n) {
            return result;
        }

        generateSum(k, n, 0, 1, 0, new ArrayList<Integer>(), result);

        return result;
    }

    private void generateSum(int k, int n, int cur, int start, int count, List<Integer> tmpResult, List<List<Integer>> result) {
        if (cur == n && count == k) {
            result.add(new ArrayList(tmpResult));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (n < cur + i) {
                return;
            }
            tmpResult.add(i);
            generateSum(k, n, cur + i, i + 1, count + 1, tmpResult, result);
            tmpResult.remove((Integer) tmpResult.size() - 1);
        }
    }
}
