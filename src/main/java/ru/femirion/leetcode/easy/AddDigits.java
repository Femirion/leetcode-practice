package ru.femirion.leetcode.easy;

/**
 * 258. Add Digits
 * https://leetcode.com/problems/add-digits/
 */
public class AddDigits {

    /**
     * Runtime 1ms Beats 88.36% of users with Java
     * Memory 40.00MB Beats 22.78% of users with Java
     */
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int result = 0;

        while (num > 1) {
            int last = num % 10;
            result = result + last;
            num = num / 10;
        }


        if (result >= 10) {
            return addDigits(result);
        } else {
            return result;
        }
    }

}
