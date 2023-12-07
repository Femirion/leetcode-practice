package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 1619. Mean of Array After Removing Some Elements
 * https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
 */
public class MeanOfArrayAfterRemovingSomeElements {

    /**
     * Runtime 3ms Beats 92.46% of users with Java
     * Memory 43.62MB Beats 18.33% of users with Java
     */
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int countOfDeleted = (int) (arr.length * 0.05);
        int sum = 0;
        for (int i = countOfDeleted; i < arr.length - countOfDeleted; i++) {
            sum = sum + arr[i];
        }
        return (double) sum / (arr.length - countOfDeleted * 2);
    }

}
