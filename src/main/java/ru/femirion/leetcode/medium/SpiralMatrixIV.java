package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ListNode;

/**
 * 2326. Spiral Matrix IV
 * https://leetcode.com/problems/spiral-matrix-iv/description/
 */
public class SpiralMatrixIV {

    private ListNode list;

    /**
     * Runtime 8 ms Beats 31.06%
     * Memory 56.52 MB Beats 87.61%
     */
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        list = head;
        int size = m * n;

        int x = 0;
        int y = 0;

        int leftLimit = 0;
        int rightLimit = n;
        int topLimit = 0;
        int bottomLimit = m;


        int[][] result = new int[m][n];
        int idx = 0;
        while (idx < size) {

            for (; x < rightLimit; x++) {
                result[y][x] = getHeadValue();
                idx++;
            }

            if (size <= idx) {
                break;
            }

            topLimit++;
            y++;
            x--;

            for (; y < bottomLimit; y++) {
                result[y][x] = getHeadValue();
                idx++;
            }

            if (size <= idx) {
                break;
            }

            rightLimit--;
            x--;
            y--;

            for (; leftLimit <= x; x--) {
                result[y][x] = getHeadValue();
                idx++;
            }

            if (size <= idx) {
                break;
            }

            y--;
            x++;
            bottomLimit--;

            for (; topLimit <= y; y--) {
                result[y][x] = getHeadValue();
                idx++;
            }

            if (size <= idx) {
                break;
            }

            x++;
            y++;
            leftLimit++;

        }

        return result;
    }

    private int getHeadValue() {
        if (list != null) {
            int value = list.val;
            list = list.next;
            return value;
        } else {
            return -1;
        }
    }
}
