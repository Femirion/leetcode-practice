package ru.femirion.leetcode.easy;

/**
 * 557. Reverse Words in a String III
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 */
public class ReverseWordsInAStringIII {

    /**
     * Runtime 8 ms Beats 48.87% of users with Java
     * Memory 45.28 MB Beats 24.49% of users with Java
     */
    public String reverseWords(String s) {
        int p = 0;
        int q = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current != ' ') {
                q++;
                continue;
            }
            int tmp = q - 1;
            while (p <= tmp) {
                sb.append(s.charAt(tmp));
                tmp--;
            }
            sb.append(' ');
            q++;
            p = q;
        }
        if (p != q) {
            int tmp = q - 1;
            while (p <= tmp) {
                sb.append(s.charAt(tmp));
                tmp--;
            }
        }
        return sb.toString();
    }
}
