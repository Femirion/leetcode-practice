package ru.femirion.leetcode.medium;

/**
 * 2241. Design an ATM Machine
 * https://leetcode.com/problems/design-an-atm-machine/description/
 */
public class DesignAnATMMachine {

    private int[] banknotes = new int[5];
    private final int[] nominals = {20, 50, 100, 200, 500};

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            banknotes[i] = banknotes[i] + banknotesCount[i];
        }
    }

    /**
     * Runtime 55 ms Beats 93.23%
     * Memory 48.25 MB Beats 65.04%
     */
    public int[] withdraw(int amount) {
        int[] result = new int[5];
        int[] tmpBanknotes = new int[5];
        System.arraycopy(banknotes, 0, tmpBanknotes, 0, banknotes.length);

        for (int i = 4; 0 <= i; i++) {
            int banknotesCount = Math.min(amount / nominals[i], banknotes[i]);
            int curAmount = banknotesCount * nominals[i];

            tmpBanknotes[i] = tmpBanknotes[i] - banknotesCount;
            amount = amount - curAmount;
            result[i] = banknotesCount;
        }

        if (amount != 0) {
            return new int[] {-1};
        }
        banknotes = tmpBanknotes;

        return result;
    }

}
