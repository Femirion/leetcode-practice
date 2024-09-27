package ru.femirion.leetcode.medium;

/**
 * 2391. Minimum Amount of Time to Collect Garbage
 * https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/
 */
public class MinimumAmountOfTimeToCollectGarbage {

    /**
     * Runtime 30 ms Beats 42.43%
     * Memory 63.67 MB Beats 40.13%
     */
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] idxs = new int[3];

        int totalTime = 0;
        for (int i = 0; i < garbage.length; i++) {
            int[] curHouseGarbage = getGarbageForHouse(garbage[i]);
            for (int type = 0; type < 3; type++) {
                if (curHouseGarbage[type] != 0) {
                    totalTime = totalTime + curHouseGarbage[type] + getTravelTime(travel, idxs[type], i);
                    idxs[type] = i;
                }
            }
        }

        return totalTime;
    }

    private int getTravelTime(int[] travel, int startIdx, int endIdx) {
        int time = 0;
        while(startIdx < endIdx) {
            time = time + travel[startIdx];
            startIdx++;
        }
        return time;
    }

    private int[] getGarbageForHouse(String garbage) {
        int[] result = new int[3];
        for (char g : garbage.toCharArray()) {
            if (g == 'G') {
                result[0]++;
                continue;
            }
            if (g == 'P') {
                result[1]++;
                continue;
            }
            if (g == 'M') {
                result[2]++;
                continue;
            }
        }
        return result;
    }
}
