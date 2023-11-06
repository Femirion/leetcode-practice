package ru.femirion.leetcode.easy;

/**
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 *
 * 1304. Find N Unique Integers Sum up to Zero
 *
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 *
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 *
 * Input: n = 1
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
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
