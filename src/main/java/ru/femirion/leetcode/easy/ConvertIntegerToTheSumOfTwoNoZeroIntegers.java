package ru.femirion.leetcode.easy;

/**
 * 1317. Convert Integer to the Sum of Two No-Zero Integers
 * https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/
 */
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.54 MB Beats 9.67% of users with Java
     */
    public int[] getNoZeroIntegers(int n) {
        int first = 1;
        int second = n - first;
        while (hasZero(first) || hasZero(second)) {
            first++;
            second--;
        }
        return new int[]{first, second};
    }

    private boolean hasZero(int num) {
        while (0 < num) {
            int cur = num % 10;
            if (cur == 0) {
                return true;
            }
            num = num / 10;
        }
        return false;
    }
}
