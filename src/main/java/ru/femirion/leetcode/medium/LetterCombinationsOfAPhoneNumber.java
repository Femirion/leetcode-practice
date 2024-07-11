package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * Runtime 4 ms Beats 42.03%
     * Memory 42.49 MB Beats 8.38%
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if ("".equals(digits)) {
            return result;
        }
        int[] charsIdx = new int[digits.length()];
        generateCodes(result, "", 0, charsIdx, digits);
        return result;
    }

    private void generateCodes(List<String> result, String tmpResult, int digitIdx, int[] charsIdx, String digits) {
        if (tmpResult.length() == digits.length()) {
            result.add(tmpResult);
            return;
        }

        char number = digits.charAt(digitIdx);
        char[] chars = characterMap.get(number);

        for (int i = 0; i < chars.length; i++) {
            if (i < charsIdx[digitIdx]) {
                continue;
            }
            char curChar = chars[i];
            charsIdx[digitIdx]++;
            generateCodes(result, tmpResult + curChar, digitIdx + 1, charsIdx, digits);
            charsIdx[digitIdx]--;
        }
    }


    private static Map<Character, char[]> characterMap = new HashMap<>();

    static {
        char[] for2 = {'a', 'b', 'c'};
        characterMap.put('2', for2);

        char[] for3 = {'d', 'e', 'f'};
        characterMap.put('3', for3);

        char[] for4 = {'g', 'h', 'i'};
        characterMap.put('4', for4);

        char[] for5 = {'j', 'k', 'l'};
        characterMap.put('5', for5);

        char[] for6 = {'m', 'n', 'o'};
        characterMap.put('6', for6);

        char[] for7 = {'p', 'q', 'r', 's'};
        characterMap.put('7', for7);

        char[] for8 = {'t', 'u', 'v'};
        characterMap.put('8', for8);

        char[] for9 = {'w', 'x', 'y', 'z'};
        characterMap.put('9', for9);
    }
}
