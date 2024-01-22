package ru.femirion.leetcode.easy;

/**
 * 482. License Key Formatting
 * https://leetcode.com/problems/license-key-formatting/description/
 */
public class LicenseKeyFormatting {

    /**
     * Runtime 10 ms Beats 91.55% of users with Java
     * Memory 44.44 MB Beats 48.27% of users with Java
     */
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char current = s.charAt(i);
            if (current == '-') {
                continue;
            }
            sb.append(Character.toUpperCase(current));
            count++;
            if (count == k) {
                count = 0;
                sb.append('-');
            }
        }
        if (sb.length() > 0 && sb.lastIndexOf("-") == sb.length() - 1) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.reverse().toString();
    }
}
