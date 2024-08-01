package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/description/
 */
public class SumIII {

    /**
     * Runtime 38 ms Beats 38.67%
     * Memory 51.32 MB Beats 64.69%
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int prevPVal = Integer.MAX_VALUE;
            int prevQVal = Integer.MAX_VALUE;

            int p = i + 1;
            int q = nums.length - 1;
            int firstP = -1;

            int pVal = nums[p];
            int qVal = nums[q];


            while (p < q) {
                pVal = nums[p];

                if (nums[i] != pVal) {
                    if (firstP == -1) {
                        firstP = p;
                    }
                }

                qVal = nums[q];

                if (prevPVal == pVal) {
                    p++;
                    continue;
                }

                if (prevQVal == qVal) {
                    q--;
                    continue;
                }

                int sum = nums[i] + pVal + qVal;
                if (sum == 0) {
                    List<Integer> tmp = List.of(nums[i], pVal, qVal);
                    result.add(tmp);
                    prevPVal = pVal;
                    p++;
                    continue;
                }

                if (0 - nums[i] < pVal + qVal) {
                    q--;
                    prevQVal = qVal;
                } else {
                    p++;
                    prevPVal = pVal;
                }
            }
            if (firstP == -1) {
                break;
            }
            i = firstP;
            i--;
        }

        return result;
    }
}
