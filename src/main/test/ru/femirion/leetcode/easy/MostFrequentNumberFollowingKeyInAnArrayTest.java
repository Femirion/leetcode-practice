package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MostFrequentNumberFollowingKeyInAnArrayTest {
    @Test
    void check() {
        // when
        var solution = new MostFrequentNumberFollowingKeyInAnArray();

        // then
        assertThat(solution.mostFrequent(new int[]{11,22,11,33,11,33}, 11)).isEqualTo(33);
    }
}