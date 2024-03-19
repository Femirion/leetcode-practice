package ru.femirion.leetcode.easy;

/**
 * 1903. Largest Odd Number in String
 * https://leetcode.com/problems/largest-odd-number-in-string/description/
 */
public class LargestOddNumberInString {

    /**
     * Runtime 1359 ms Beats 5.03% of users with Java
     * Memory 45.16 MB Beats 72.11% of users with Java
     */
    public String largestOddNumber(String num) {
        char[] arr = num.toCharArray();
        char cur;
        StringBuilder sb = new StringBuilder();

        boolean hasOddNumber = false;
        for (int i = num.length() - 1; 0 <= i; i--) {
            cur = arr[i];
            if (hasOddNumber) {
                sb.insert(0, cur);
                continue;
            }
            if (cur != '1'
                && cur != '3'
                && cur != '5'
                && cur != '7'
                && cur != '9') {
                continue;
            }
            sb.insert(0, cur);
            hasOddNumber = true;
        }

        return sb.toString();
    }
}
