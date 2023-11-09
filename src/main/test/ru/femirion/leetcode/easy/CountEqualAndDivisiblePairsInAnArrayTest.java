package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CountEqualAndDivisiblePairsInAnArrayTest {
    @Test
    void countPairs() {
        // when
        var solution = new CountEqualAndDivisiblePairsInAnArray();

        // then
        assertThat(solution.countPairs(new int[] {3,1,2,2,2,1,3}, 2)).isEqualTo(4);
    }
}