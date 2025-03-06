package ru.femirion.leetcode.medium;

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/description/
 */
public class WordSearch {

    private boolean result = false;;
    private String word;
    private char[][] board;
    private int n = 0;
    private int m = 0;

    /**
     * Runtime 261 ms Beats 15.03%
     * Memory 41.66 MB Beats 62.09%
     */
    public boolean exist(char[][] searchBoard, String searchWord) {
        if (searchBoard.length == 1 && searchBoard[0].length == 1 && searchWord.length() == 1) {
            return searchWord.charAt(0) == searchBoard[0][0];
        }

        word = searchWord;
        board = searchBoard;

        n = board.length;
        m = board[0].length;

        int idx = 0;

        for (int i = 0; i < searchBoard.length; i++) {
            for (int j = 0; j < searchBoard[0].length; j++) {
                char c = board[i][j];
                int[][] usedPositions = new int[searchBoard.length][searchBoard[0].length];
                backtracking(0, i, j, usedPositions);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    private void backtracking(int idx, int x, int y, int[][] usedPositions) {
        if (result) {
            return;
        }

        if (idx == word.length()) {
            result = true;
            return;
        }

        if (0 <= x - 1) {
            if (usedPositions[x - 1][y] == 0 && board[x - 1][y] == word.charAt(idx)) {
                usedPositions[x - 1][y] = 1;
                backtracking(idx + 1, x - 1, y, usedPositions);
                usedPositions[x - 1][y] = 0;
            }
        }

        if (x + 1 < n) {
            if (usedPositions[x + 1][y] == 0 && board[x + 1][y] == word.charAt(idx)) {
                usedPositions[x + 1][y] = 1;
                backtracking(idx + 1, x + 1, y, usedPositions);
                usedPositions[x + 1][y] = 0;
            }
        }

        if (0 <= y - 1) {
            if (usedPositions[x][y - 1] == 0 && board[x][y - 1] == word.charAt(idx)) {
                usedPositions[x][y - 1] = 1;
                backtracking(idx + 1, x, y - 1, usedPositions);
                usedPositions[x][y - 1] = 0;
            }
        }

        if (y + 1 < m) {
            if (usedPositions[x][y + 1] == 0 && board[x][y + 1] == word.charAt(idx)) {
                usedPositions[x][y + 1] = 1;
                backtracking(idx + 1, x, y + 1, usedPositions);
                usedPositions[x][y + 1] = 0;
            }
        }
    }
}
