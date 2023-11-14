package ru.femirion.leetcode.easy;

/**
 * 1880. Check if Word Equals Summation of Two Words
 * https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
 */
public class CheckIfWordEqualsSummationOfTwoWords {

    /**
     * Runtime 1ms Beats 44.66% of users with Java
     * Memory 41.12MB Beats 6.94% of users with Java
     */
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < firstWord.length(); i++) {
            sb.append(firstWord.charAt(i) - 97);
        }
        int firstDigit = Integer.parseInt(sb.toString());

        sb = new StringBuilder();
        for (int i = 0; i < secondWord.length(); i++) {
            sb.append(secondWord.charAt(i) - 97);
        }
        int secondDigit = Integer.parseInt(sb.toString());

        sb = new StringBuilder();
        for (int i = 0; i < targetWord.length(); i++) {
            sb.append(targetWord.charAt(i) - 97);
        }
        int targetDigit = Integer.parseInt(sb.toString());

        return firstDigit + secondDigit == targetDigit;
    }

    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 41.01MB Beats 6.94% of users with Java
     */
    public boolean isSumEqual1(String firstWord, String secondWord, String targetWord) {
        int count = 1;
        int firstDigit = 0;
        for (int i = firstWord.length() - 1; i >= 0; i--) {
            int current = (int) firstWord.charAt(i) - 97;
            firstDigit = firstDigit + count * current;
            count = count * 10;
        }

        count = 1;
        int secondDigit = 0;
        for (int i = secondWord.length() - 1; i >= 0; i--) {
            int current = (int) secondWord.charAt(i) - 97;
            secondDigit = secondDigit + count * current;
            count = count * 10;
        }

        count = 1;
        int targetDigit = 0;
        for (int i = targetWord.length() - 1; i >= 0; i--) {
            int current = (int) targetWord.charAt(i) - 97;
            targetDigit = targetDigit + count * current;
            count = count * 10;
        }

        return firstDigit + secondDigit == targetDigit;
    }

}
