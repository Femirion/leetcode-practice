package ru.femirion.leetcode.medium;

/**
 * 6. Zigzag Conversion
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
public class ZigzagConversion {

    /**
     * Runtime: 2 ms, faster than 99.71% of Java online submissions for Zigzag Conversion.
     * Memory Usage: 41.9 MB, less than 95.71% of Java online submissions for Zigzag Conversion.
     */
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        var result = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                result.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    result.append(s.charAt(j + cycleLen - i));
            }
        }
        return result.toString();
    }

}

