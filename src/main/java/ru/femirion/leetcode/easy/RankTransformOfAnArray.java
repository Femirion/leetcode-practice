package ru.femirion.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. Rank Transform of an Array
 * https://leetcode.com/problems/rank-transform-of-an-array/description/
 */
public class RankTransformOfAnArray {

    /**
     * Runtime 26 ms Beats 69.92%
     * Memory 61.89 MB Beats 63.80%
     */
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }

        int[] tmpArr = new int[arr.length];
        System.arraycopy(arr, 0, tmpArr, 0, arr.length);
        Arrays.sort(tmpArr);
        int rank = 1;
        Map<Integer, Integer> rankMap = new HashMap<>();
        rankMap.put(tmpArr[0], rank);
        for (int i = 1; i < tmpArr.length; i++) {
            if (tmpArr[i] != tmpArr[i - 1]) {
                rank++;
                rankMap.put(tmpArr[i], rank);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        return arr;
    }
}
