package ru.femirion.leetcode.medium;

/**
 * 2125. Number of Laser Beams in a Bank
 * https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/
 */
public class NumberOfLaserBeamsInABank {

    /**
     * Runtime 10 ms Beats 91.95%
     * Memory 45.33 MB Beats 19.39%
     */
    public int numberOfBeams(String[] bank) {
        int prevCount = 0;

        int i = 0;
        while (i < bank.length && prevCount == 0) {
            prevCount = getSecDeviceCount(bank[i]);
            i++;
        }

        if (i == bank.length) {
            return 0;
        }

        int result = 0;
        for (; i < bank.length; i++) {
            int curCount = getSecDeviceCount(bank[i]);
            if (curCount == 0) {
                continue;
            }
            result = result + curCount * prevCount;
            prevCount = curCount;
        }
        return result;
    }

    private int getSecDeviceCount(String flor) {
        int count = 0;
        for (char c : flor.toCharArray()) {
            if (c - '0' == 1) {
                count++;
            }
        }
        return count;
    }
}
