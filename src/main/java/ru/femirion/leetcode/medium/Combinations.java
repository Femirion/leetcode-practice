package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * https://leetcode.com/problems/combinations/description/
 */
public class Combinations {

    /**
     * Runtime 18 ms Beats 81.46%
     * Memory 94.74 MB Beats 22.65%
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtracking(result, new ArrayList<>(), n, k, 1);

        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> tmpResult, int end, int count, int current) {
        if (tmpResult.size() == count) {
            result.add(new ArrayList<>(tmpResult));
            return;
        }

        for (int i = current; i <= end; i++) {
            tmpResult.add(i);
            backtracking(result, tmpResult, end, count, i + 1);
            tmpResult.remove((Integer) tmpResult.size() - 1);
        }
    }
}
