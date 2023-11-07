package ru.femirion.leetcode.easy;

/**
 * 2409. Count Days Spent Together
 * https://leetcode.com/problems/count-days-spent-together/
 */
public class CountDaysSpentTogether {

    /**
     * Runtime 1ms Beats 38.60% of users with Java
     * Memory 40.23MB Beats 70.18% of users with Java
     */
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        Date arriveAliceDate = new Date(arriveAlice);
        Date leaveAliceDate = new Date(leaveAlice);
        Date arriveBobDate = new Date(arriveBob);
        Date leaveBobDate = new Date(leaveBob);

        int arriveAliceDay = arriveAliceDate.getDayOfYear();
        int leaveAliceDay = leaveAliceDate.getDayOfYear();
        int arriveBobDay = arriveBobDate.getDayOfYear();
        int leaveBobDay = leaveBobDate.getDayOfYear();

        int result = 0;
        if (arriveBobDay <= arriveAliceDay) {
            if (leaveBobDay < arriveAliceDay) {
                return 0;
            }
            if (leaveBobDay <= leaveAliceDay) {
                return leaveBobDay - arriveAliceDay + 1;
            } else {
                return leaveAliceDay - arriveAliceDay + 1;
            }
        }
        if (arriveBobDay > leaveAliceDay) {
            return 0;
        }
        if (leaveBobDay <= leaveAliceDay) {
            return leaveBobDay - arriveBobDay + 1;
        } else {
            return leaveAliceDay - arriveBobDay + 1;
        }
    }

    private static class Date {

        private static final int[] DAY_OF_MONTH = new int[] {
                0,
                31,
                31 + 28,
                31 + 28 + 31,
                31 + 28 + 31 + 30,
                31 + 28 + 31 + 30 + 31,
                31 + 28 + 31 + 30 + 31 + 30,
                31 + 28 + 31 + 30 + 31 + 30 + 31,
                31 + 28 + 31 + 30 + 31 + 30 + 31 + 31,
                31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30,
                31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31,
                31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30};
        final byte month;
        final byte day;

        private Date(byte month, byte day) {
            this.month = month;
            this.day = day;
        }

        private Date(String date) {
            String[] dates = date.split("-");
            this.month = Byte.parseByte(dates[0]);
            this.day = Byte.parseByte(dates[1]);
        }

        public int getDayOfYear() {
            return DAY_OF_MONTH[month - 1] + day;
        }
    }

}
