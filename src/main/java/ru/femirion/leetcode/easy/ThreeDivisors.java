package ru.femirion.leetcode.easy;

/**
 * 1952. Three Divisors
 * https://leetcode.com/problems/three-divisors/
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
