package ru.femirion.leetcode.easy;

/**
 * 1550. Three Consecutive Odds
 * https://leetcode.com/problems/three-consecutive-odds/
 */
public class ThreeConsecutiveOdds {

    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 41.03MB Beats 51.26% of users with Java
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            int n1 = arr[i];
            int n2 = arr[i + 1];
            int n3 = arr[i + 2];
            if (n3 % 2 == 0) {
                i = i + 2;
                continue;
            }
            if (n2 % 2 == 0) {
                i = i + 1;
                continue;
            }
            if (n1 % 2 != 0) {
                return true;
            }
        }
        return false;
    }

}
