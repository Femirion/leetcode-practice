package ru.femirion.leetcode.easy;

/**
 * 1351. Count Negative Numbers in a Sorted Matrix
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
 */
public class CountNegativeNumbersInASortedMatrix {

    /**
     * Runtim 0 ms Beats 100.00% of users with Java
     * Memory 45.84 MB Beats 9.21% of users with Java
     */
    public int countNegatives(int[][] grid) {
        int count = 0;
        int start;
        int end;
        int currentIdx;
        int current;
        for (int i = 0; i < grid.length; i++) {
            start = 0;
            end = grid.length - 1;
            currentIdx = (end - start) / 2;
            while(start <= end){
                current = grid[i][currentIdx];
                if (end - start == 1 || end == start) {
                    if (grid[i][start] < 0) {
                        count = count + (grid[i].length - start);
                        break;
                    }
                    if (grid[i][end] >= 0) {
                        break;
                    }
                    count = count + end - start;
                    break;
                }
                if (current >= 0) {
                    start = currentIdx;
                    currentIdx = start + ((end - start) / 2);
                    continue;
                }
                if (currentIdx - 1 <= 0 || grid[i][currentIdx - 1] > 0) {
                    count = count + (grid[i].length - currentIdx);
                    break;
                }
                end = currentIdx;
                currentIdx = end - ((end - start) / 2);
            }
        }
        return count;
    }
}
