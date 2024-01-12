package ru.femirion.leetcode.easy;

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/description/
 */
public class ReverseString {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 49.04 MB Beats 80.49% of users with Java
     */
    public void reverseString(char[] s) {
        int p = 0;
        int q = s.length - 1;

        while (p <= q) {
            char temp = s[p];
            s[p] = s[q];
            s[q] = temp;
            q--;
            q++;
        }
    }

}
