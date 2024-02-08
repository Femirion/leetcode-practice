package ru.femirion.leetcode.medium;

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class ReverseInteger {

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
