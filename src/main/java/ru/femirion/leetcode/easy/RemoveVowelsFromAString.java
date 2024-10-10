package ru.femirion.leetcode.easy;

/**
 * 1119. Remove Vowels from a String
 * https://leetcode.com/problems/remove-vowels-from-a-string/description/
 */
public class RemoveVowelsFromAString {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.56 MB Beats 33.14%
     */
    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == 'a'
                    || c == 'e'
                    || c == 'i'
                    || c == 'o'
                    || c == 'u') {
                continue;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
