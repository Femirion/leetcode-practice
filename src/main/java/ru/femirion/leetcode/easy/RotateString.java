package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 796. Rotate String
 * https://leetcode.com/problems/rotate-string/description/
 */
public class RotateString {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.21 MB Beats 65.05%
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        char g = goal.charAt(0);
        char[] sarr = s.toCharArray();
        List<Integer> startPoints = new ArrayList<>();
        for (int i = 0; i < sarr.length; i++) {
            if (sarr[i] == g) {
                startPoints.add(i);
            }
        }
        if (startPoints.isEmpty()) {
            return false;
        }

        boolean isRotatedString;
        for (int start : startPoints) {
            isRotatedString = true;
            int j = start;
            for (int i = 0; i < goal.length(); i++) {
                char sC = s.charAt(j);
                char gC = goal.charAt(i);
                if (sC != gC) {
                    isRotatedString = false;
                    break;
                }
                j++;
                if (j == s.length()) {
                    j = 0;
                }
            }
            if (isRotatedString) {
                return true;
            }
        }
        return false;
    }
}
