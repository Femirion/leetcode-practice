package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CheckIfWordEqualsSummationOfTwoWordsTest {
    @Test
    void countTime() {
        // when
        var solution = new CheckIfWordEqualsSummationOfTwoWords();

        // then
        assertThat(solution.isSumEqual("acb", "cba", "cdb")).isEqualTo(true);
    }
}