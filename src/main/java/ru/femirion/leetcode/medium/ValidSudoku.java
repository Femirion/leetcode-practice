package ru.femirion.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/description/
 */
public class ValidSudoku {

    /**
     * Runtime 3 ms Beats 60.69% of users with Java
     * Memory 43.80 MB Beats 97.90% of users with Java
     */
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> numbersInRow = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int curRowValue = board[j][i] - '0';
                if (numbersInRow.contains(curRowValue)) {
                    return false;
                } else {
                    numbersInRow.add(curRowValue);
                }
            }
            numbersInRow = new HashSet<>();
        }

        Set<Integer> numbersInColumn = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int curColumnValue = board[i][j] - '0';
                if (numbersInColumn.contains(curColumnValue)) {
                    return false;
                } else {
                    numbersInColumn.add(curColumnValue);
                }
            }
            numbersInColumn = new HashSet<>();
        }

        int offsetY = 0;
        Set<Integer> numbersInSquare = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int offsetX = i * 3;
            for (int a = offsetX; a < 3 + offsetX; a++) {
                for (int b = offsetY; b < 3 + offsetY; b++) {
                    if (board[b][a] == '.') {
                        continue;
                    }
                    int curSquareValue = board[b][a] - '0';
                    if (numbersInSquare.contains(curSquareValue)) {
                        return false;
                    } else {
                        numbersInSquare.add(curSquareValue);
                    }
                }
            }
            numbersInSquare = new HashSet<>();
            if (i == 2) {
                offsetY = offsetY + 3;
                i = -1;
            }
            if (8 < offsetY) {
                break;
            }
        }

        return true;
    }

}
