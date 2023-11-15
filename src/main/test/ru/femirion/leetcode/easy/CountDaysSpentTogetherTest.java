package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CountDaysSpentTogetherTest {

    @Test
    void check() {
        String arriveAlice = "08-06";
        String leaveAlice = "12-08";
        String arriveBob = "02-04";
        String leaveBob = "09-01";

        // when
        var solution = new CountDaysSpentTogether();
        var result = solution.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);

        // then
        assertThat(result).isEqualTo(27);
    }

}