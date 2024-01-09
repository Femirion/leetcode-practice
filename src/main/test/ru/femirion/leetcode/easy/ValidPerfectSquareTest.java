package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ValidPerfectSquareTest {
    @Test
    void check() {
        // when
        var solution = new ValidPerfectSquare();

        // then
        assertThat(solution.isPerfectSquare(17)).isEqualTo(true);
    }
}