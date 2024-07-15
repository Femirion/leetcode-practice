package ru.femirion.leetcode.medium;

/**
 * 849. Maximize Distance to Closest Person
 * https://leetcode.com/problems/maximize-distance-to-closest-person/description/
 */
public class MaximizeDistanceToClosestPerson {

    /**
     * Runtime 2 ms Beats 98.20%
     * Memory 46.51 MB Beats 29.28%
     */
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int countZero = 0;
        boolean leftSide = true;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                countZero++;
                continue;
            }
            if (max < countZero) {
                if (leftSide) {
                    max = countZero;
                } else {
                    int tmpMax = (countZero + 1) / 2;
                    if (max < tmpMax) {
                        max = tmpMax;
                    }
                }
            }
            countZero = 0;
            leftSide = false;
        }

        if (max < countZero) {
            max = countZero;
        }
        return max;
    }
}
