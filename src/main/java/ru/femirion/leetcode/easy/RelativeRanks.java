package ru.femirion.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 506. Relative Ranks
 * https://leetcode.com/problems/relative-ranks/
 */
public class RelativeRanks {

    private static final String FIRST_PLACE_MSG = "Gold Medal";
    private static final String SECOND_PLACE_MSG = "Silver Medal";
    private static final String THIRD_PLACE_MSG = "Bronze Medal";

    /**
     * Runtime 12ms Beats 26.03% of users with Java
     * Memory 45.12MB Beats 9.48% of users with Java
     */
    public String[] findRelativeRanks(int[] score) {
        ScoreData[] datas = new ScoreData[score.length];
        for (int i = 0; i < score.length; i++) {
            ScoreData d = new ScoreData(score[i], i);
            datas[i] = d;
        }

        Arrays.sort(datas, (a, b) -> Integer.compare(b.value,  a.value));

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length ; i++) {
            map.put(datas[i].index, i);
        }

        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int currentPlace = map.get(i);
            if (currentPlace == 0) {
                result[i] = FIRST_PLACE_MSG;
                continue;
            }
            if (currentPlace == 1) {
                result[i] = SECOND_PLACE_MSG;
                continue;
            }
            if (currentPlace == 2) {
                result[i] = THIRD_PLACE_MSG;
                continue;
            }
            result[i] = Integer.toString(currentPlace + 1);
        }
        return result;
    }

    private static class ScoreData {
        private final int value;
        private final int index;

        private ScoreData(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
