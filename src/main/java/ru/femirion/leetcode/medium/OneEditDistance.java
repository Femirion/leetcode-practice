package ru.femirion.leetcode.medium;

/**
 * 161. One Edit Distance
 * https://leetcode.com/problems/one-edit-distance/description/
 */
public class OneEditDistance {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 42.04 MB Beats 33.61%
     */
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == 1 && t.length() == 1) {
            return s.charAt(0) != t.charAt(0);
        }
        int minLength = Math.min(s.length(), t.length());

        int p = 0;
        int q = 0;
        boolean wasDeleted = false;

        for (int i = 0; i < minLength; i++) {
            if (s.charAt(p) == t.charAt(q)) {
                p++;
                q++;
                continue;
            }
            return isOneDistance(s, t, p + 1, q + 1)
                    || isOneDistance(s, t, p, q + 1)
                    || isOneDistance(s, t, p + 1, q);
        }

        return Math.abs(s.length() - t.length()) == 1;
    }

    private boolean isOneDistance(String s, String t, int p, int q) {
        while (p < s.length() && q < t.length()) {
            if (s.charAt(p) != t.charAt(q)) {
                return false;
            }
            p++;
            q++;
        }

        return p == s.length() && q == t.length();
    }
}
