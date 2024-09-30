package ru.femirion.leetcode.medium;

/**
 * 3271. Hash Divided String
 * https://leetcode.com/problems/hash-divided-string/description/
 */
public class HashDividedString {

    /**
     * Runtime 2 ms Beats 96.32%
     * Memory 44.86 MB Beats 53.13%
     */
    public String stringHash(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int curSum = 0;
        for(char c : s.toCharArray()) {
            if (i < k) {
                curSum = curSum + (c - 'a');
                i++;
                if (i == k) {
                    sb.append((char) ((curSum % 26) + 'a'));
                    i = 0;
                    curSum = 0;
                }
            }
        }

        return sb.toString();
    }
}
