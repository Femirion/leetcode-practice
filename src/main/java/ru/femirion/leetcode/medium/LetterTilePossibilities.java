package ru.femirion.leetcode.medium;

/**
 * 1079. Letter Tile Possibilities
 * https://leetcode.com/problems/letter-tile-possibilities/description/
 */
public class LetterTilePossibilities {

    int result = 0;
    int[] chars;

    /**
     * Runtime 2 ms Beats 87.75%
     * Memory 41.45 MB Beats 85.91%
     */
    public int numTilePossibilities(String tiles) {
        chars = new int[26];
        for (char c : tiles.toCharArray()) {
            chars[c - 'A']++;
        }

        int end = 0;
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                end = i;
            }
        }

        backtraking(0, tiles.length(), end);

        return result - 1;
    }

    private void backtraking(int curSize, int totalSize, int end) {
        if (curSize <= totalSize) {
            result++;
        }

        if (curSize == totalSize) {
            return;
        }

        for (int i = 0; i <= end; i++) {
            if (chars[i] == 0) {
                continue;
            }
            chars[i]--;
            backtraking(curSize + 1, totalSize, end);
            chars[i]++;
        }
    }
}
