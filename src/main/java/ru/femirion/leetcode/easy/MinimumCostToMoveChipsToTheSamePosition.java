package ru.femirion.leetcode.easy;

/**
 * 1217. Minimum Cost to Move Chips to The Same Position
 * https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 */
public class MinimumCostToMoveChipsToTheSamePosition {

    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 40.46MB Beats 18.85% of users with Java
     */
    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;

        for(int p : position){
            if (p % 2 == 0) {
                even++;
            }
            else odd++;
        }

        return Math.min(even,odd);
    }

}
