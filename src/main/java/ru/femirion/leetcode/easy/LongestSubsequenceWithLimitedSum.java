package ru.femirion.leetcode.easy;

import java.util.*;

/**
 * 2389. Longest Subsequence With Limited Sum
 * https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
 */
public class LongestSubsequenceWithLimitedSum {

    /**
     * Runtime 5 ms Beats 99.22% of users with Java
     * Memory 44.94 MB Beats 37.33% of users with Java
     */
    public int[] answerQueries1(int[] nums, int[] queries) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int pos = Arrays.binarySearch(nums, queries[i]);
            result[i] = Math.abs(pos + 1);
        }

        return result;
    }


    /**
     * Runtime 17 ms Beats 9.19% of users with Java
     * Memory 45.28 MB Beats 15.70% of users with Java
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < queries.length; i++) {
            List<Integer> list = map.getOrDefault(queries[i], new ArrayList<>());
            list.add(i);
            map.put(queries[i], list);
        }

        long sum = 0;
        int p = 0;
        int query;
        int[] result = new int[queries.length];
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            query = e.getKey();
            while (sum < query && p < nums.length) {
                if (sum + nums[p] <= query) {
                    sum = sum + nums[p];
                    p++;
                } else {
                    break;
                }
            }
            for (int indx : e.getValue()) {
                result[indx] = p;
            }
        }
        return result;
    }
}
