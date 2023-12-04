package ru.femirion.leetcode.easy;

/**
 * 1221. Split a String in Balanced Strings
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */
public class SplitAStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int countL = 0;
        int countR = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == 'R') {
                countR++;
            } else {
                countL++;
            }
            if (countL == countR) {
                result++;
                countR = 0;
                countL = 0;
            }
        }
        return result;
    }

}
