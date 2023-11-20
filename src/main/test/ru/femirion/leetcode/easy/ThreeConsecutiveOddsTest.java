package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ThreeConsecutiveOddsTest {
    @Test
    void check() {
        // given
        ThreeConsecutiveOdds solution = new ThreeConsecutiveOdds();

        // then
        assertThat(solution.threeConsecutiveOdds(new int[] {1, 1, 1})).isEqualTo(true);
    }
}