package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/description/
 */
public class PermutationInString {

    /**
     * Runtime 310 ms Beats 13.72%
     * Memory 45.06 MB Beats 14.45%
     */
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int[] chars = new int[26];
            Arrays.fill(chars, -1);
            for (int i = 0; i < s1.length(); i++) {
                int curChar = s1.charAt(i) - 'a';
                if (chars[curChar] == -1) {
                    chars[curChar]++;
                }
                chars[curChar]++;
            }

            for (int i = 0; i < s2.length(); i++) {
                int[] tmp = new int[26];
                System.arraycopy(chars, 0, tmp, 0, 26);
                for (int j = i; j < s2.length(); j++) {
                    int curChar = s2.charAt(j) - 'a';
                    if (tmp[curChar] == 0) {
                        break;
                    }
                    if (tmp[curChar] < 0) {
                        i = j;
                        break;
                    }
                    tmp[curChar]--;
                    if (tmp[curChar] == 0) {
                        boolean hasFound = true;
                        for (int k = 0; k < 26; k++) {
                            if (tmp[k] > 0) {
                                hasFound = false;
                                break;
                            }
                        }
                        if (hasFound) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
