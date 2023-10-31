package ru.femirion.leetcode.easy;

/**
 * 1952. Three Divisors
 *
 * https://leetcode.com/problems/three-divisors/
 *
 * Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.
 *
 * An integer m is a divisor of n if there exists an integer k such that n = k * m.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: false
 * Explantion: 2 has only two divisors: 1 and 2.
 * Example 2:
 *
 * Input: n = 4
 * Output: true
 * Explantion: 4 has three divisors: 1, 2, and 4.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 */
public class ThreeDivisors {

    /**
     * 0ms Beats 100.00%of users with Java
     * 38.73MB Beats 96.35%of users with Java
     */
    public boolean isThree(int n) {
        byte devisors = 2;
        for (int i = 2; i < n - 1; i++) {
            if (n % i == 0) {
                devisors++;
                if (devisors > 3) {
                    return false;
                }
            }
        }
        return devisors == 3;
    }

}
