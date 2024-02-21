package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 2300. Successful Pairs of Spells and Potions
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/
 */
public class SuccessfulPairsOfSpellsAndPotions {

    /**
     * Runtime 47 ms Beats 20.68% of users with Java
     * Memory 64.28 MB Beats 66.47% of users with Java
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] result = new int[spells.length];
        int count;
        int start;
        int end;
        int currentIdx;
        long prev;
        long current;
        int currentSpell;
        for (int i = 0; i < spells.length; i++) {
            count = 0;
            start = 0;
            end = potions.length - 1;
            currentSpell = spells[i];
            while (start <= end) {
                currentIdx = start + ((end - start) / 2);
                current = (long) potions[currentIdx] * currentSpell;
                if (currentIdx - 1 >= 0) {
                    prev = (long) potions[currentIdx - 1] * currentSpell;
                } else {
                    prev = 0;
                }
                if (current >= success && prev < success) {
                    count = count + potions.length - currentIdx;
                    break;
                }
                if (current >= success) {
                    end = currentIdx - 1;
                } else  {
                    start = currentIdx + 1;
                }
            }
            result[i] = count;
        }

        return result;
    }
}
