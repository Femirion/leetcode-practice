package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MaximumOddBinaryNumberTest {
    @Test
    void check() {
        // when
        var solution = new MaximumOddBinaryNumber();

        // then
        assertThat(solution.maximumOddBinaryNumber("1010101011")).isEqualTo("1111100001");
    }
}