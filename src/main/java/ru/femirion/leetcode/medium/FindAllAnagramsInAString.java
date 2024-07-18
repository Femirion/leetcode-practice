package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
public class FindAllAnagramsInAString {

    /**
     * Runtime 356 ms Beats 15.61%
     * Memory 45.41 MB Beats 23.42%
     */
    public List<Integer> findAnagrams(String s, String p) {
        int[] pChars =  new int[26];

        for (char cur : p.toCharArray()) {
            pChars[cur - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int[] sSubChars = new int[26];
            for (int j = i; j < i + p.length(); j++) {
                sSubChars[s.charAt(j) - 'a']++;
            }

            String tmp = s.substring(i, i + p.length());
            char tmp1 = s.charAt(i);

            boolean isSame = true;
            for (int k = 0; k < 26; k++) {
                if (pChars[k] != sSubChars[k]) {
                    isSame = false;
                    break;
                }
            }

            if(isSame) {
                result.add(i);
            }
        }
        return result;
    }
}
