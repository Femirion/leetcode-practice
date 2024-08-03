package ru.femirion.leetcode.easy;

/**
 * 171. Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class ExcelSheetColumnNumber {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.64 MB Beats 97.36%
     */
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char cur = columnTitle.charAt(i);
            int curIdx = cur - 'A' + 1;
            if (i == 0) {
                result = curIdx;
            } else {
                result = result * 26 + curIdx;
            }
        }

        return result;
    }
}
