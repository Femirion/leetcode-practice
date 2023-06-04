package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BuildArrayFromPermutationTest {
    @Test
    void shouldHandleMessage() {
        // when
        var solution = new BuildArrayFromPermutation();

        // then
        int[] expected = {0, 1, 2, 4, 5, 3};
        assertThat(solution.buildArray1(new int[]{0, 2, 1, 5, 3, 4})).isEqualTo(expected);
    }
}