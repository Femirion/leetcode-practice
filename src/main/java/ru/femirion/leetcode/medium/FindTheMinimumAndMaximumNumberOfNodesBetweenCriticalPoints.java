package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.ListNode;

/**
 * 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
 * https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/
 *
 * #Lists
 */
public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

    /**
     * Runtime 4 ms Beats 100.00%
     * Memory 56.64 MB Beats 94.69%
     */
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int left = -1;
        int middle = -1;
        int right = -1;

        int minDistance = -1;
        int maxDistance = -1;

        int[] result = {minDistance, maxDistance};

        if (head.next != null) {
            left = head.val;
            head = head.next;
        } else {
            return result;
        }

        if (head.next != null) {
            middle = head.val;
            head = head.next;
        } else {
            return result;
        }

        int firstPoint = 0;
        int lastPoint = 0;

        int i = 2;
        while(head != null) {
            right = head.val;

            if ((middle < left && middle < right) || (left < middle && right < middle)) {
                if (firstPoint != 0) {
                    if (lastPoint == 0) {
                        lastPoint = i;
                        minDistance = lastPoint - firstPoint;
                        maxDistance = minDistance;
                    } else {
                        int curDistance = i - lastPoint;
                        if (curDistance < minDistance) {
                            minDistance = curDistance;
                        }
                        lastPoint = i;
                        maxDistance = i - firstPoint;
                    }
                } else {
                    firstPoint = i;
                }
            }

            left = middle;
            middle = head.val;
            head = head.next;
            i++;
        }

        return new int[] {minDistance, maxDistance};
    }
}
