package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RelativeRanksTest {
    @Test
    void check() {
        // when
        var solution = new RelativeRanks();

        // then
        assertThat(solution.findRelativeRanks(new int[]{10,3,8,9,4})).isEqualTo(new String[]{"Gold Medal","5","Bronze Medal","Silver Medal","4"});
    }
}