package ru.femirion.leetcode.easy;

/**
 * 459. Repeated Substring Pattern
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 */
public class RepeatedSubstringPattern {

    /**
     * Runtime 41 ms Beats 56.51% of users with Java
     * Memory 44.87 MB Beats 84.51% of users with Java
     */
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();
        String tmp;
        for (int i = 1; i <= s.length() - 1; i++) {
            sb.append(s.charAt(i - 1));
            if (s.length() % i != 0) {
                continue;
            }
            tmp = concate(sb.toString(), s.length() / i);
            if (tmp.equals(s)) {
                return true;
            }
        }
        return false;
    }

    private String concate(String str, int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
