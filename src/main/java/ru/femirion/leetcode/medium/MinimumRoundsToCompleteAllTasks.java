package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 2244. Minimum Rounds to Complete All Tasks
 * https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/
 */
public class MinimumRoundsToCompleteAllTasks {

    /**
     * Runtime 12 ms Beats 98.26%
     * Memory 57.91 MB Beats 35.25%
     */
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int count = 1;
        int result = 0;
        for (int i = 1; i < tasks.length + 1; i++) {
            if (i != tasks.length && tasks[i] == tasks[i - 1]) {
                count++;
                continue;
            }
            if (count == 1) {
                return -1;
            }
            int div = count % 3;
            if (div == 0) {
                div = count / 3;
            } else if (div == 2) {
                div = count / 3 + 1;
            } else if (div == 1) {
                div = (count - 2) / 3 + 2;
            }
            result = result + div;
            count = 1;
        }
        return result;
    }
}
