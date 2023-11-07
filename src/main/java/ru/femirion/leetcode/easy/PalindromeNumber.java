package ru.femirion.leetcode.easy;

/**
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    /**
     * Runtime: 16 ms, faster than 31.33% of Java online submissions for Palindrome Number.
     * Memory Usage: 44.7 MB, less than 51.16% of Java online submissions for Palindrome Number.
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (x == res || x == res / 10);
    }
}
