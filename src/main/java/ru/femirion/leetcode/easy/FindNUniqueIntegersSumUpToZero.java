package ru.femirion.leetcode.easy;

/**
 * 1304. Find N Unique Integers Sum up to Zero
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 */
public class FindNUniqueIntegersSumUpToZero {

    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 40.36MB Beats 84.23% of users with Java
     */
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int i = 0;
        int j = n - 1;
        while(i < j) {
            result[i] = -j;
            result[j] = j;
            i++;
            j--;
        }
        return result;
    }
}
