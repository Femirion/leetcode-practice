package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1630. Arithmetic Subarrays
 * https://leetcode.com/problems/arithmetic-subarrays/description/
 */
public class ArithmeticSubarrays {

    /**
     * Runtime 19 ms Beats 47.96%
     * Memory 45.20 MB Beats 76.73%
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>(l.length);

        int[][] arr = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (x, y) -> x[0] - y[0]);

        for (int i = 0; i < l.length; i++) {
            int start = l[i];
            int end = r[i];
            Integer first = null;
            Integer second = null;
            int diff = 0;
            boolean isValid = true;
            for (int j = 0; j < nums.length; j++) {
                int idx = arr[j][1];
                if (start <= idx && idx <= end) {
                    if (first == null) {
                        first = arr[j][0];
                        continue;
                    }
                    if (second == null) {
                        second = arr[j][0];
                        diff = second - first;
                        continue;
                    }
                    if (arr[j][0] - second != diff) {
                        isValid = false;
                        break;
                    } else {
                        second = arr[j][0];
                    }
                }
            }
            result.add(isValid);
        }

        return result;
    }
}
