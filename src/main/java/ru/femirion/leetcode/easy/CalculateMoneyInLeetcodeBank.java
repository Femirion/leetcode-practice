package ru.femirion.leetcode.easy;

/**
 * 1716. Calculate Money in Leetcode Bank
 * https://leetcode.com/problems/calculate-money-in-leetcode-bank/
 */
public class CalculateMoneyInLeetcodeBank {
    /**
     * Runtime 1ms Beats 58.85% of users with Java
     * Memory 39.63MB Beats 10.87% of users with Java
     */
    public int totalMoney(int n) {
        int total = 0;
        int moneyOnMonday = 1;
        int currentMoney = 1;
        for (int i = 1; i <= n; i++) {
            total = total + currentMoney;
            currentMoney++;
            if (i % 7 == 0) {
                moneyOnMonday++;
                currentMoney = moneyOnMonday;
            }
        }
        return total;
    }
}
