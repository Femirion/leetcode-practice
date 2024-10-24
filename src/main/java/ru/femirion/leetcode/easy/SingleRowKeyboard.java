package ru.femirion.leetcode.easy;

/**
 * 1165. Single-Row Keyboard
 * https://leetcode.com/problems/single-row-keyboard/
 */
public class SingleRowKeyboard {

    /**
     * Runtime 4 ms Beats 97.75%
     * Memory 42.35 MB Beats 35.13%
     */
    public int calculateTime(String keyboard, String word) {
        int[] keys = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            keys[keyboard.charAt(i) - 'a'] = i;
        }

        int result = 0;
        int curPosition = 0;
        for (char w : word.toCharArray()) {
            result = Math.abs(curPosition - keys[w - 'a']) + result;
            curPosition = keys[w - 'a'];
        }

        return result;
    }
}
