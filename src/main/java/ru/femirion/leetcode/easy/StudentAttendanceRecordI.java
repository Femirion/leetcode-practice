package ru.femirion.leetcode.easy;

/**
 * 551. Student Attendance Record I
 * https://leetcode.com/problems/student-attendance-record-i/
 */
public class StudentAttendanceRecordI {

    /**
     * Runtime 0ms Beats 100.00%of users with Java
     * Memory 40.20MB Beats 90.95%of users with Java
     */
    public boolean checkRecord(String s) {
        byte countOfLate = 0;
        int countOfAbsent = 0;
        for (int i = 0; i < s.length(); i++) {
            char curren = s.charAt(i);
            if (curren == 'A') {
                countOfAbsent++;
                if (countOfAbsent == 2) {
                    return false;
                }
                countOfLate = 0;
            }
            if (curren == 'L') {
                countOfLate++;
                if (countOfLate == 3) {
                    return false;
                }
            }
            if (curren == 'P') {
                countOfLate = 0;
            }
        }
        return true;
    }

}
