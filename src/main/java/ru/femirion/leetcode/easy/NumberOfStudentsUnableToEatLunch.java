package ru.femirion.leetcode.easy;

/**
 * 1700. Number of Students Unable to Eat Lunch
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/
 */
public class NumberOfStudentsUnableToEatLunch {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.22 MB Beats 61.94% of users with Java
     */
    public int countStudents(int[] students, int[] sandwiches) {
        int students1InQueue = 0;
        int students0InQueue = 0;
        int stP = 0;
        int sndP = 0;
        while (sndP < sandwiches.length) {
            int curStudent;
            int curSand = sandwiches[sndP];
            if (stP >= students.length) {
                if (curSand == 1) {
                    if (students1InQueue == 0) {
                        return students0InQueue;
                    }
                    curStudent = 1;
                    students1InQueue--;
                } else {
                    if (students0InQueue == 0) {
                        return students1InQueue;
                    }
                    curStudent = 0;
                    students0InQueue--;
                }
            } else {
                curStudent = students[stP];
            }
            if (curSand == curStudent) {
                stP++;
                sndP++;
                continue;
            }
            if (curStudent == 1) {
                students1InQueue++;
            } else {
                students0InQueue++;
            }
            stP++;
        }
        return 0;
    }
}
