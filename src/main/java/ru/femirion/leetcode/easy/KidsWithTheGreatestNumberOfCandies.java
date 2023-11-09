package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. Kids With the Greatest Number of Candies
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class KidsWithTheGreatestNumberOfCandies {

    /**
     * Runtime 1ms Beats 94.51% of users with Java
     * Memory 41.08MB Beats 88.71% of users with Java
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = candies[0];
        for (int i = 0; i < candies.length; i++) {
            if (max < candies[i]) {
                max = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }
}
