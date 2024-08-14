package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 2037. Minimum Number of Moves to Seat Everyone
 * https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/
 */
public class MinimumNumberOfMovesToSeatEveryoneSolved {

    /**
     * Runtime 3 ms Beats 60.38%
     * Memory 44.02 MB Beats 55.52%
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int result = 0;

        for (int i = 0; i < seats.length; i++) {
            int diff = Math.abs(students[i] - seats[i]);
            result = result + diff;
        }

        return result;
    }
}
