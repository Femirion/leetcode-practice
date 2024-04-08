package ru.femirion.leetcode.easy;

/**
 * 2485. Find the Pivot Integer
 */
public class FindThePivotInteger {

    /**
     * Runtime 1 ms Beats 62.03% of users with Java
     * Memory 40.61 MB Beats 36.73% of users with Java
     */
    public int pivotInteger(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        int leftSum = sum;
        int rightSum = 0;
        for (int i = n; 0 < i; i--) {
            rightSum = rightSum + i;
            if (leftSum == rightSum) {
                return i;
            }
            leftSum = leftSum - i;
        }
        return -1;
    }
}
