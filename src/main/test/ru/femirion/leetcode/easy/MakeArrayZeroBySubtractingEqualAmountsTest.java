package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MakeArrayZeroBySubtractingEqualAmountsTest {
    @Test
    void check() {
        // when
        var solution = new MakeArrayZeroBySubtractingEqualAmounts();

        // then
        assertThat(solution.minimumOperations(new int[]{7,28,34,76})).isEqualTo(4);
    }
}