package ru.femirion.leetcode.easy;

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    /**
     * Runtime 0ms Beats 100.00%of users with Java
     * Memory 41.86MB Beats 13.77%of users with Java
     */
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int size = digits.length - 1;

        if (digits[size] == 9) {
            carry = 1;
            digits[size] = 0;
        } else {
            digits[size] = digits[size] + 1;
        }


        for (int i = size - 1; 0 <= i; i--) {
            if (carry == 1) {
                digits[i] = digits[i] + 1;
                if (digits[i] == 10) {
                    digits[i] = 0;
                    carry = 1;
                } else {
                    carry = 0;
                }
            }
        }

        if (digits[0] == 0 && carry == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length - 1);
            return newDigits;
        } else {
            return digits;
        }
    }
}
