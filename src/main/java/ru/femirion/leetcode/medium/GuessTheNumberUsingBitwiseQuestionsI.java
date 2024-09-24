package ru.femirion.leetcode.medium;

/**
 * 3064. Guess the Number Using Bitwise Questions I
 * https://leetcode.com/problems/guess-the-number-using-bitwise-questions-i/description/
 */
public class GuessTheNumberUsingBitwiseQuestionsI {

    /**
     * Runtime 2 ms Beats 46.43%
     * Memory 41.04 MB Beats 57.14%
     */
    public int findNumber() {
        int result = 0;

        for (int i = 0; i < 30; i++) {
            int quessNum = 1 << i;
            if (commonSetBits(quessNum) == 1) {
                result = result + quessNum;
            }
        }

        return result;
    }

    /**
     * stub for leetcode
     */
    private int commonSetBits(int num) {
        return 0;
    }
}
