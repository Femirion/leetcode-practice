package ru.femirion.leetcode.easy;

/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/description/
 */
public class HappyNumber {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.64 MB Beats 56.59% of users with Java
     */
    public boolean isHappy(int n) {
        int quick = n;
        int slow = n;

        while (true) {
            quick = getHappyNumber(getHappyNumber(quick));
            slow = getHappyNumber(slow);

            if (quick == 1 || slow == 1) {
                return true;
            }
            if (quick == slow) {
                return false;
            }
        }
    }

    private int getHappyNumber(int number) {
        int n = 0;
        int cur;
        while (0 < number) {
            cur = number % 10;
            n = n + (cur * cur);
            number = number / 10;
        }
        return n;
    }
}
