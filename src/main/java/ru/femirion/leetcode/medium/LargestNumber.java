package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 179. Largest Number
 * https://leetcode.com/problems/largest-number/description/
 */
public class LargestNumber {

    /**
     * Runtime 5 ms Beats 98.55%
     * Memory 44.28 MB Beats 14.31%
     */
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            StringBuilder strA = new StringBuilder(a);
            StringBuilder strB = new StringBuilder(b);
            return strB.append(strA).compareTo(strA.append(strB));
        });

        if ("0".equals(arr[0])) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String str : arr) {
            sb.append(str);
        }

        return sb.toString();
    }


}
