package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2545. Sort the Students by Their Kth Score
 * https://leetcode.com/problems/sort-the-students-by-their-kth-score/description/
 */
public class SortTheStudentsByTheirKthScore {

    /**
     * Runtime 8 ms Beats 7.20%
     * Memory 53.09 MB Beats 5.49%
     */
    public int[][] sortTheStudents(int[][] score, int k) {
        Set<Integer> existedScores = new HashSet<>();
        List<Integer> maxIdxs = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            int max = Integer.MIN_VALUE;
            int maxIdx = -1;
            for (int j = 0; j < score.length; j++) {
                if (max < score[j][k] && !existedScores.contains(score[j][k])) {
                    max = score[j][k];
                    maxIdx = j;
                }
            }
            existedScores.add(max);
            maxIdxs.add(maxIdx);
        }

        for (int i = 0; i < score[0].length; i++) {
            int[] tmp = new int[score.length];
            for (int j = 0; j < score.length; j++) {
                tmp[j] = score[maxIdxs.get(j)][i];
            }
            for (int j = 0; j < score.length; j++) {
                score[j][i] = tmp[j];
            }
        }

        return score;
    }
}
