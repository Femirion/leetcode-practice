package ru.femirion.leetcode.easy;

/**
 * 1768. Merge Strings Alternately
 * https://leetcode.com/problems/merge-strings-alternately/description/
 */
public class MergeStringsAlternately {

    /**
     * Runtime 1 ms Beats 84.71% of users with Java
     * Memory 41.35 MB Beats 84.06% of users with Java
     */
    public String mergeAlternately(String word1, String word2) {
        int p = 0;
        int q = 0;
        int current = 0;
        StringBuilder sb = new StringBuilder();
        while (p < word1.length() || q < word2.length()) {
            if (p > word1.length() - 1) {
                current = 1;
            }
            if (q > word2.length() - 1) {
                current = 0;
            }
            if (current % 2 == 0) {
                sb.append(word1.charAt(p));
                p++;
            } else {
                sb.append(word2.charAt(q));
                q++;
            }
            current++;
        }
        return sb.toString();
    }

    /**
     * Runtime 1 ms Beats 84.71% of users with Java
     * Memory 42.10 MB Beats 31.55% of users with Java
     */
    public String mergeAlternately1(String word1, String word2) {
        int p = 0;
        int q = 0;
        int current = 0;
        char[] arr = new char[word1.length() + word2.length()];
        int i = 0;
        while (p < word1.length() || q < word2.length()) {
            if (p > word1.length() - 1) {
                current = 1;
            }
            if (q > word2.length() - 1) {
                current = 0;
            }
            if (current % 2 == 0) {
                arr[i] = word1.charAt(p);
                p++;
                i++;
            } else {
                arr[i] = word2.charAt(q);
                q++;
                i++;
            }
            current++;
        }
        return new String(arr);
    }
}
