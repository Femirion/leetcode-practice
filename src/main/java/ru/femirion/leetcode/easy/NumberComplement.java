package ru.femirion.leetcode.easy;

/**
 * 476. Number Complement
 * https://leetcode.com/problems/number-complement/
 */
public class NumberComplement {

    /**
     * Runtime 1ms Beats 30.14%of users with Java
     * Memory 39.72MB Beats 13.11% of users with Java
     */
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            char current = binary.charAt(i);
            if (current == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        String result = sb.toString();
        return Integer.parseInt(result, 2);
    }

}
