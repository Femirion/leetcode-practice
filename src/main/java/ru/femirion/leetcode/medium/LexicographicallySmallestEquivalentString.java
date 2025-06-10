package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 1061. Lexicographically Smallest Equivalent String
 * https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
 */
public class LexicographicallySmallestEquivalentString {

    /**
     * Runtime 7 ms Beats 39.84%
     * Memory 42.05 MB Beats 68.85%
     */
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, int[]> chars = new HashMap<>();

        for (int j = 0; j < s1.length(); j++) {
            char c1 = s1.charAt(j);
            char c2 = s2.charAt(j);
            int[] s1Set = chars.get(c1);
            int[] s2Set = chars.get(c2);

            if (s1Set == null && s2Set == null) {
                int[] set = new int[26];
                set[c1 - 'a'] = 1;
                set[c2 - 'a'] = 1;
                chars.put(c1, set);
                chars.put(c2, set);
                continue;
            }

            if (s1Set != null && s2Set == null) {
                s1Set[c2 - 'a'] = 1;
                for (int i = 0; i < 26; i++) {
                    if (s1Set[i] != 0) {
                        chars.put((char) ('a' + i), s1Set);
                    }
                }
                continue;
            }

            if (s1Set == null && s2Set != null) {
                s2Set[c1 - 'a'] = 1;
                for (int i = 0; i < 26; i++) {
                    if (s2Set[i] != 0) {
                        chars.put((char) ('a' + i), s2Set);
                    }
                }
                continue;
            }

            if (s1Set != null && s2Set != null) {
                for (int i = 0; i < 26; i++) {
                    if (s2Set[i] != 0) {
                        s1Set[i] = s2Set[i];
                    }
                    if (s1Set[i] != 0) {
                        chars.put((char) ('a' + i), s1Set);
                    }
                }
                continue;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int[] arr = chars.get(baseStr.charAt(i));
            if (arr == null) {
                sb.append(baseStr.charAt(i));
                continue;
            }
            for (int j = 0; j < 26; j++) {
                if (arr[j] != 0) {
                    sb.append((char) (j + 'a'));
                    break;
                }
            }
        }
        return sb.toString();
    }
}
