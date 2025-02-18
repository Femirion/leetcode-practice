package ru.femirion.leetcode.medium;

/**
 * 2375. Construct Smallest Number From DI String
 * https://leetcode.com/problems/construct-smallest-number-from-di-string/description/
 */
public class ConstructSmallestNumberFromDIString {

    private int result = Integer.MAX_VALUE;
    private String str;

    /**
     * Runtime 13 ms Beats 11.64%
     * Memory 41.97 MB Beats 25.41%
     */
    public String smallestNumber(String pattern) {
        int[] existedNums = new int[10];

        str = pattern;

        char firstChar = pattern.charAt(0);
        int firstVal = firstChar == 'I' ? 0 : 10;

        generateNumber(existedNums, 0, firstVal, firstChar, pattern, 0);
        return Integer.toString(result);
    }

    private void generateNumber(int[] existedNums, int curSize, int prevVal, char prevChar, String pattern, int actualNum) {
        if (curSize == pattern.length() + 1) {
            result = Math.min(result, actualNum);
            return;
        }

        char c = curSize != pattern.length() ? pattern.charAt(curSize) : prevChar;

        for (int i = 1; i < 10; i++) {
            if (existedNums[i] == 1) {
                continue;
            }

            if (prevChar == 'D') {
                if (i < prevVal) {
                    actualNum = actualNum * 10 + i;
                    existedNums[i] = 1;
                    generateNumber(existedNums, curSize + 1, i, c, pattern, actualNum);
                    existedNums[i] = 0;
                    actualNum = (actualNum - i) / 10;
                }
            } else {
                if (prevVal < i) {
                    actualNum = actualNum * 10 + i;
                    existedNums[i] = 1;
                    generateNumber(existedNums, curSize + 1, i, c, pattern, actualNum);
                    existedNums[i] = 0;
                    actualNum = (actualNum - i) / 10;
                }
            }
        }
    }
}
