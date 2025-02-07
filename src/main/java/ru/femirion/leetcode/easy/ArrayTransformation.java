package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1243. Array Transformation
 * https://leetcode.com/problems/array-transformation/description/
 */
public class ArrayTransformation {

    /**
     * Runtime 2 ms Beats 75.93%
     * Memory 42.36 MB Beats 5.56%
     */
    public List<Integer> transformArray(int[] arr) {
        boolean wasUpdated = true;

        while(wasUpdated) {
            wasUpdated = false;
            int[] tmp = new int[arr.length];
            System.arraycopy(arr, 0, tmp, 0, arr.length);
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                    tmp[i]--;
                    wasUpdated = true;
                    continue;
                }
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    tmp[i]++;
                    wasUpdated = true;
                }
            }
            arr = tmp;
        }

        List<Integer> result = new ArrayList<>();
        for (int ar : arr) {
            result.add(ar);
        }
        return result;
    }
}
