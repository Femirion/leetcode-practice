package ru.femirion.leetcode.easy;

/**
 * 860. Lemonade Change
 * https://leetcode.com/problems/lemonade-change/description/
 */
public class LemonadeChange {

    /**
     * Runtime 2 ms Beats 95.12%
     * Memory 55.73 MB Beats 63.21%
     */
    public boolean lemonadeChange(int[] bills) {
        int tenCount = 0;
        int fiveCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
                continue;
            }
            if (bills[i] == 10) {
                if (0 < fiveCount) {
                    fiveCount--;
                    tenCount++;
                    continue;
                } else {
                    return false;
                }
            }
            if (bills[i] == 20) {
                if (0 < fiveCount) {
                    if (0 < tenCount) {
                        fiveCount--;
                        tenCount--;
                        continue;
                    } else if (3 <= fiveCount) {
                        fiveCount = fiveCount - 3;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
