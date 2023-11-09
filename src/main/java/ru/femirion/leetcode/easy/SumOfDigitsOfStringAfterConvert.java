package ru.femirion.leetcode.easy;

/**
 * 1945. Sum of Digits of String After Convert
 * https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
 */
public class SumOfDigitsOfStringAfterConvert {
    /**
     * Runtime 2ms Beats 62.20% of users with Java
     * Memory 40.26MB Beats 93.30% of users with Java
     */
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 96);
        }

        for (int i = 0; i < k; i++) {
            String tmp = sb.toString();
            sb = new StringBuilder();
            int sum = 0;
            for (int j = 0; j < tmp.length(); j++) {
                char current = tmp.charAt(j);
                byte digit = (byte) (current - 48);
                sum = sum + digit;
            }
            sb.append(sum);
        }

        return Integer.parseInt(sb.toString());
    }
}
