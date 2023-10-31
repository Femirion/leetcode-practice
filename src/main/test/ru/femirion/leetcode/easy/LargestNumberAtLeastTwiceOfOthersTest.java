package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LargestNumberAtLeastTwiceOfOthersTest {
    @Test
    void shouldHandleMessage() {
        // when
        var solution = new LargestNumberAtLeastTwiceOfOthers();

        // then
        assertThat(solution.dominantIndex(new int[] {3,6,1,0})).isEqualTo(1);
    }
}