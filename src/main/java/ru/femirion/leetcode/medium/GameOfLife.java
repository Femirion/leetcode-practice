package ru.femirion.leetcode.medium;

/**
 * 289. Game of Life
 * https://leetcode.com/problems/game-of-life/description/
 */
public class GameOfLife {

    /**
     * Runtime 1 ms Beats 23.07%
     * Memory 41.84 MB Beats 38.70%
     */
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean isAlive = board[i][j] == 1;

                int[] counts = {0, 0, 0};
                counts[check1(board, i, j)]++;
                counts[check2(board, i, j)]++;
                counts[check3(board, i, j)]++;
                counts[check4(board, i, j)]++;
                counts[check5(board, i, j)]++;
                counts[check6(board, i, j)]++;
                counts[check7(board, i, j)]++;
                counts[check8(board, i, j)]++;

                if (isAlive) {
                    if (counts[2] < 2) {
                        board[i][j] = -1;
                    }
                    if (counts[2] == 2 || counts[2] == 3) {
                        board[i][j] = 1;
                    }
                    if (3 < counts[2]) {
                        board[i][j] = -1;
                    }
                } else {
                    if (counts[2] == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int check1(int[][] board, int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        return Math.abs(board[i - 1][j - 1]) == 1 ? 2 : 0;
    }

    private int check2(int[][] board, int i, int j) {
        if (i == 0) {
            return 0;
        }
        return Math.abs(board[i - 1][j]) == 1 ? 2 : 0;
    }

    private int check3(int[][] board, int i, int j) {
        if (i == 0 || j + 1 == board[i].length) {
            return 0;
        }
        return Math.abs(board[i - 1][j + 1]) == 1 ? 2 : 0;
    }

    private int check4(int[][] board, int i, int j) {
        if (j == 0) {
            return 0;
        }
        return Math.abs(board[i][j - 1]) == 1 ? 2 : 0;
    }

    private int check5(int[][] board, int i, int j) {
        if (j + 1 == board[i].length) {
            return 0;
        }
        return Math.abs(board[i][j + 1]) == 1 ? 2 : 0;
    }

    private int check6(int[][] board, int i, int j) {
        if (i + 1 == board.length || j == 0) {
            return 0;
        }
        return Math.abs(board[i + 1][j - 1]) == 1 ? 2 : 0;
    }

    private int check7(int[][] board, int i, int j) {
        if (i + 1 == board.length ) {
            return 0;
        }
        return Math.abs(board[i + 1][j]) == 1 ? 2 : 0;
    }

    private int check8(int[][] board, int i, int j) {
        if (i + 1 == board.length|| j + 1 == board[i].length) {
            return 0;
        }
        return Math.abs(board[i + 1][j + 1]) == 1 ? 2 : 0;
    }
}
