package ru.femirion.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RomanToIntegerTest {

    @Test
    void check() {
        // when
        var solution = new RomanToInteger();

        // then
        assertThat(solution.romanToInt("III")).isEqualTo(3);
        assertThat(solution.romanToInt("MCMXCIV")).isEqualTo(1994);
    }

}