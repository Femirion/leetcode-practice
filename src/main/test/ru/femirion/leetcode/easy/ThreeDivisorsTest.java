package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ThreeDivisorsTest {
    @Test
    void check() {
        // given
        ThreeDivisors solution = new ThreeDivisors();

        // then
        assertThat(solution.isThree(4)).isEqualTo(true);
    }
}