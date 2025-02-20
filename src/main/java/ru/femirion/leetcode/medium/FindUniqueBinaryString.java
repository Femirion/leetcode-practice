package ru.femirion.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 1980. Find Unique Binary String
 * https://leetcode.com/problems/find-unique-binary-string/description/
 */
public class FindUniqueBinaryString {

    /**
     * Runtime 2 ms Beats 51.83%
     * Memory 40.92 MB Beats 99.48%
     */
    public String findDifferentBinaryString(String[] nums) {
        Set<String> existedStrs = new HashSet<>();

        for (String num : nums) {
            existedStrs.add(num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append('0');
        }

        for(;;) {
            sb = getNextString(sb);
            if (!existedStrs.contains(sb.toString())) {
                return sb.toString();
            }
        }
    }

    private StringBuilder getNextString(StringBuilder sb) {
        for (int i = sb.length() - 1; 0 <= i; i--) {
            char last = sb.charAt(i);
            if (last == '0') {
                sb.setCharAt(i, '1');
                break;
            } else {
                sb.setCharAt(i, '0');
            }
        }
        return sb;
    }
}
