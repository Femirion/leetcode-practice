package ru.femirion.leetcode.easy;

/**
 * 1295. Find Numbers with Even Number of Digits
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
 */
public class FindNumbersWithEvenNumberOfDigits {

    /**
     * Runtime 1 ms Beats 97.88% of users with Java
     * Memory 42.13 MB Beats 65.23% of users with Java
     */
    public int findNumbers(int[] nums) {
        int counts = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isEvenNumberOfDigits(nums[i])) {
                counts++;
            }
        }
        return counts;
    }

    private boolean isEvenNumberOfDigits(int num) {
        int count = 0;
        int position = 0;
        while (0 <= num) {
            int current = num % 10;
            if (num == 0) {
                return count % 2 == 0;
            }
            count++;
            num = num / 10;
        }
        return false;
    }

}
