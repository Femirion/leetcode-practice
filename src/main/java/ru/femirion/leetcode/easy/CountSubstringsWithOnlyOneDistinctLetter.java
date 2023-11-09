package ru.femirion.leetcode.easy;

/**
 * 1180. Count Substrings with Only One Distinct Letter
 * https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/
 */
public class CountSubstringsWithOnlyOneDistinctLetter {

    /**
     * Runtime 1ms Beats 81.48% of users with Java
     * Memory 40.03MB Beats 82.41% of users with Java
     */
    public int countLetters(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int result = 0;
        int currentCount = 0;
        char prev = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (prev != current) {
                prev = current;
                result = result + getAlgSum(currentCount);
                currentCount = 1;
            } else {
                currentCount++;
            }
        }
        return result + getAlgSum(currentCount);
    }

    private int getAlgSum(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            result = result + i;
        }
        return result;
    }

}
