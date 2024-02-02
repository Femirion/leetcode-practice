package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/description/
 */
public class JewelsAndStones {

    /**
     * Runtime 1 ms Beats 69.28% of users with Java
     * Memory 42.07 MB Beats 9.54% of users with Java
     */
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            char current = jewels.charAt(i);
            jewelSet.add(current);
        }

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            char current = stones.charAt(i);
            if (jewelSet.contains(current)) {
                count++;
            }
        }
        return count;
    }

}
