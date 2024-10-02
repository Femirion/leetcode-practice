package ru.femirion.leetcode.medium;

/**
 * 2120. Execution of All Suffix Instructions Staying in a Grid
 * https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/description/
 */
public class ExecutionOfAllSuffixInstructionsStayingInAGrid {

    /**
     * Runtime 30 ms Beats 56.04%
     * Memory 45.22 MB Beats 11.54%
     */
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] result = new int[s.length()];

        int curPos = 0;
        for (char move : s.toCharArray()) {
            int x = startPos[1];
            int y = startPos[0];
            int possibleCount = 0;

            for (int i = curPos; i < s.length(); i++) {
                char next = s.charAt(i);
                if (next == 'R') {
                    x = x + 1;
                }
                if (next == 'L') {
                    x = x - 1;
                }
                if (next == 'U') {
                    y = y - 1;
                }
                if (next == 'D') {
                    y = y + 1;
                }
                if (x < 0 || n - 1 < x) {
                    break;
                }
                if (y < 0 || n - 1 < y) {
                    break;
                }
                possibleCount++;
            }
            result[curPos] = possibleCount;
            curPos++;
        }
        return result;
    }
}
