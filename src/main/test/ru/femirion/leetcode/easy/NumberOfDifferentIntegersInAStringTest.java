package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberOfDifferentIntegersInAStringTest {

    @Test
    void check() {
        // when
        var solution = new NumberOfDifferentIntegersInAString();

        // then
        assertThat(solution.numDifferentIntegers("a1b01c001")).isEqualTo(1);
    }

}