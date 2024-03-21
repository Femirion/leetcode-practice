package ru.femirion.leetcode.easy;

/**
 * 1684. Count the Number of Consistent Strings
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/description/
 */
public class CountTheNumberOfConsistentStrings {

    /**
     * Runtime 5 ms Beats 98.06% of users with Java
     * Memory 44.45 MB Beats 99.60% of users with Java
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int[] chars = new int[26];
        for (char cur : allowed.toCharArray()) {
            chars[cur - 'a']++;
        }

        int result = 0;
        for (String word : words) {
            boolean isAllowedWord = true;
            for (char cur : word.toCharArray()) {
                if (chars[cur - 'a'] == 0) {
                    isAllowedWord = false;
                    break;
                }
            }
            if (isAllowedWord) {
                result++;
            }
        }
        return result;
    }
}
