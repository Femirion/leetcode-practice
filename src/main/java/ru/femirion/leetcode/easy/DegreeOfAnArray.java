package ru.femirion.leetcode.easy;

import java.util.HashMap;

/**
 * 97. Degree of an Array
 * https://leetcode.com/problems/degree-of-an-array/description/
 */
public class DegreeOfAnArray {

    /**
     * Runtime 16 ms Beats 80.87% of users with Java
     * Memory 49.30 MB Beats 16.28% of users with Java
     */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){

            if (!map.containsKey(nums[i])){
                map.put(nums[i], new int[]{i, i, 1});
                continue;
            }

            int[] arr = map.get(nums[i]);
            arr[1] = i;
            arr[2]++;
            map.put(nums[i], arr);
        }

        int maxFreq = Integer.MIN_VALUE;
        int minDist = Integer.MAX_VALUE;

        for (int[] value : map.values()) {
            if (value[2] > maxFreq){
                maxFreq = value[2];
                minDist = value[1] - value[0] + 1;
            } else if (value[2] == maxFreq) {
                minDist = Math.min(minDist, value[1] - value[0] + 1);
            }
        }
        return minDist;
    }
}
