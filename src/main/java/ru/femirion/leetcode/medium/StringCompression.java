package ru.femirion.leetcode.medium;

/**
 * 443. String Compression
 * https://leetcode.com/problems/string-compression/description/
 */
public class StringCompression {

    /**
     * Runtime 1 ms Beats 99.45% of users with Java
     * Memory 43.89 MB Beats 67.15% of users with Java
     */
    public int compress(char[] chars) {
        int w = 0;

        char curr;
        char prev = chars[0];
        int length = 1;
        String str;

        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length) {
                curr = '-';
            } else {
                curr = chars[i];
            }

            if (curr == prev) {
                length++;
                continue;
            }
            chars[w] = prev;
            w++;
            if (length != 1) {
                str = Integer.toString(length);
                for (int j = 0; j < str.length(); j++) {
                    chars[w] = str.charAt(j);
                    w++;
                }
            }
            prev = curr;
            length = 1;
        }

        return w;
    }
}
