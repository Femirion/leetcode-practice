package ru.femirion.leetcode.medium;

/**
 * 334. Increasing Triplet Subsequence
 */
public class IncreasingTripletSubsequence {

    /**
     * Runtime 2 ms Beats 94.72% of users with Java
     * Memory 133.60 MB Beats 71.85% of users with Java
     */
    public boolean increasingTriplet1(int[] nums) {
        int small = Integer.MAX_VALUE;
        int medium = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= small) {
                small = nums[i];
                continue;
            }
            if (nums[i] <= medium) {
                medium = nums[i];
                continue;
            }
            return true;
        }
        return false;
    }

    /**
     * Runtime 5 ms Beats 14.39% of users with Java
     * Memory 133.38 MB Beats 85.83% of users with Java
     */
    public boolean increasingTriplet(int[] nums) {
        int f = nums[0];
        Integer fC = null;
        int s = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr <= f) {
                if (fC == null) {
                    fC = curr;
                } else {
                    if (fC < curr) {
                        f = fC;
                        s = curr;
                        fC = null;
                    } else {
                        fC = curr;
                    }
                }
            } else {
                if (s < curr) {
                    if (isIncreasingTriplet(f, s, curr)) {
                        return true;
                    } else {
                        s = curr;
                    }
                } else {
                    s = curr;
                }
            }
        }
        return false;
    }

    private boolean isIncreasingTriplet(int f, int s, int t) {
        return f < s && s < t;
    }
}
