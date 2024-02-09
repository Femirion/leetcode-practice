package ru.femirion.leetcode.easy;

/**
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 */
public class ValidPalindromeII {

    /**
     * Runtime 5 ms Beats 41.35% of users with Java
     * Memory 45.32 MB Beats 42.42% of users with Java
     */
    public boolean validPalindrome(String s) {
        int p = 0;
        int q = s.length() - 1;
        char[] arr =  s.toCharArray();
        while (p < q) {
            if (arr[p] != arr[q]) {
                return isPalindrome(arr, p + 1, q) || isPalindrome(arr, p, q - 1);
            }
            p++;
            q--;
        }
        return true;
    }

    private boolean isPalindrome(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
