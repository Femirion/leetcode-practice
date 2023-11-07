package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 645. Set Mismatch
 * https://leetcode.com/problems/set-mismatch/
 */
public class SetMismatch {

    // TODO need to find better solution
    /**
     * Runtime 12ms Beats 17.07%of users with Java
     * Memory 45.45MB Beats 5.63%of users with Java
     */
    public int[] findErrorNums(int[] nums) {
        int[] result = {-1, -1};
        Set<Integer> duplicateSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            if (duplicateSet.contains(currentValue)) {
                result[0] = currentValue;
            } else {
                duplicateSet.add(currentValue);
            }
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (!duplicateSet.contains(i)) {
                result[1] = i;
            }
        }
        return result;
    }

}
