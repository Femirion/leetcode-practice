package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberOfValidClockTimesTest {
    @Test
    void countTime() {
        // when
        var solution = new NumberOfValidClockTimes();

        // then
        assertThat(solution.countTime("??:??")).isEqualTo(1440);
        assertThat(solution.countTime("2?:??")).isEqualTo(240);
    }
}