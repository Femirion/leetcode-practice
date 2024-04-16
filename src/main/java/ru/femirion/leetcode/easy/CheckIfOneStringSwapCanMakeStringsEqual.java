package ru.femirion.leetcode.easy;

/**
 * 1790. Check if One String Swap Can Make Strings Equal
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.08 MB Beats 94.57% of users with Java
     */
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int p = 0;
        int q = 0;

        boolean hasDiff = false;
        int diffPos = 0;
        boolean wasSwapMake = false;

        while (p < s1.length()) {
            int v1 = s1.charAt(p);
            int v2 = s2.charAt(q);

            if (v1 != v2) {
                if (hasDiff) {
                    if (!wasSwapMake) {
                        if (v1 == s2.charAt(diffPos) && v2 == s1.charAt(diffPos)) {
                            wasSwapMake = true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    diffPos = p;
                    hasDiff = true;
                }
            }
            p++;
            q++;
        }
        if (hasDiff) {
            return wasSwapMake;
        } else {
            return true;
        }
    }
}
