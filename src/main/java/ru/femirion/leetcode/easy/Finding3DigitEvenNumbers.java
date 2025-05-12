package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2094. Finding 3-Digit Even Numbers
 * https://leetcode.com/problems/finding-3-digit-even-numbers/description/
 */
public class Finding3DigitEvenNumbers {

    /**
     * Runtime 4 ms Beats 96.05%
     * Memory 44.65 MB Beats 82.46%
     */
    public int[] findEvenNumbers(int[] digits) {
        int[] nums = new int[10];

        for (int i : digits) {
            nums[i]++;
        }

        List<Integer> resultList = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[i]--;
            for (int j = 0; j <= 9; j++) {
                if (nums[j] == 0) {
                    continue;
                }
                nums[j]--;
                for (int z = 0; z <= 8; z = z + 2) {
                    if (nums[z] == 0) {
                        continue;
                    }
                    resultList.add(i * 100 + j * 10 + z);
                }
                nums[j]++;
            }
            nums[i]++;
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
