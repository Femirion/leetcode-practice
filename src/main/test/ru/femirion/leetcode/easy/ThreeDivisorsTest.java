package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ThreeDivisorsTest {
    @Test
    void check() {
        // given
        ThreeDivisors divisors = new ThreeDivisors();

        // then
        assertThat(divisors.isThree(4)).isEqualTo(true);
    }
}