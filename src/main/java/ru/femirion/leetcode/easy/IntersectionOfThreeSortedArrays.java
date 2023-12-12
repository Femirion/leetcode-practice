package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1213. Intersection of Three Sorted Arrays
 * https://leetcode.com/problems/intersection-of-three-sorted-arrays/
 */
public class IntersectionOfThreeSortedArrays {

    /**
     * Runtime 3ms Beats 47.25% of users with Java
     * Memory 44.32MB Beats 14.90% of users with Java
     */
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int e1 = 0;
        int e2 = 0;
        int e3 = 0;


        List<Integer> result = new ArrayList<>();
        while (p1 < arr1.length || p2 < arr2.length || p3 < arr3.length) {
            if (p1 < arr1.length) {
                e1 = arr1[p1];
            } else {
                e1 = 2001;
            }

            if (p2 < arr2.length) {
                e2 = arr2[p2];
            } else {
                e2 = 2001;
            }

            if (p3 < arr3.length) {
                e3 = arr3[p3];
            } else {
                e3 = 2001;
            }

            if (e1 == e2 && e2 == e3) {
                result.add(e1);
                p1++;
                p2++;
                p3++;
                continue;
            }

            if (e1 < e2) {
                if (e1 < e3) {
                    p1++;
                } else {
                    p3++;
                }
            } else {
                if (e2 < e3) {
                    p2++;
                } else {
                    p3++;
                }
            }
        }
        return result;
    }

}
