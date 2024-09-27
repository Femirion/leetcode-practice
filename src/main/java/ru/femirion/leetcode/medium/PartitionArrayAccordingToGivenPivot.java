package ru.femirion.leetcode.medium;

/**
 * 2161. Partition Array According to Given Pivot
 * https://leetcode.com/problems/partition-array-according-to-given-pivot/description/
 */
public class PartitionArrayAccordingToGivenPivot {

    /**
     * Runtime 5 ms Beats 77.99%
     * Memory 61.26 MB Beats 84.53%
     */
    public int[] pivotArray(int[] nums, int pivot) {
        int[] less = new int[nums.length];
        int[] equal = new int[nums.length];
        int[] greater =  new int[nums.length];

        int lessIdx = 0;
        int equalIdx = 0;
        int greaterIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                less[lessIdx] = nums[i];
                lessIdx++;
                continue;
            }
            if (nums[i] == pivot) {
                equal[equalIdx] = nums[i];
                equalIdx++;
                continue;
            }
            if (pivot < nums[i]) {
                greater[greaterIdx] = nums[i];
                greaterIdx++;
            }
        }

        int idx = 0;
        for (int i = 0; i < lessIdx; i++) {
            nums[idx] = less[i];
            idx++;
        }
        for (int i = 0; i < equalIdx; i++) {
            nums[idx] = equal[i];
            idx++;
        }
        for (int i = 0; i < greaterIdx; i++) {
            nums[idx] = greater[i];
            idx++;
        }
        return nums;
    }
}
