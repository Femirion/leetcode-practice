package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TwoFurthestHousesWithDifferentColorsTest {
    @Test
    void check() {
        // given
        TwoFurthestHousesWithDifferentColors solution = new TwoFurthestHousesWithDifferentColors();

        // then
        assertThat(solution.maxDistance(new int[] {1,2,1,1,1,1,1})).isEqualTo(5);
    }
}