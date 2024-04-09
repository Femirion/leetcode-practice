package ru.femirion.leetcode.medium;

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class ReverseInteger {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.11 MB Beats 98.50% of users with Java
     */
    public int reverse1(int x) {
        long result = 0;

        while (x != 0) {
            if (result * 10 > Integer.MAX_VALUE || result * 10 < Integer.MIN_VALUE) {
                return 0;
            }

            int cur = x % 10;
            result = result * 10 + cur;
            x = x / 10;
        }

        return (int) result;
    }

    /**
     * Runtime 2 ms Beats 19.43%  of users with Java
     * Memory 41.08  MB  Beats 25.42% of users with Java
     */
    public int reverse(int x) {
        boolean isNegative = x < 0;
        String str = Integer.toString(x);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        if (isNegative) {
            str = sb.substring(0, str.length() - 1);
        } else {
            str = sb.toString();
        }
        try {
            int integer = Integer.parseInt(str);
            if (isNegative) {
                integer = integer * -1;
            }
            return integer;
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
