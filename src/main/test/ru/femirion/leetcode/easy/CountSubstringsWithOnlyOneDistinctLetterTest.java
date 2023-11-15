package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CountSubstringsWithOnlyOneDistinctLetterTest {

    @Test
    void check() {
        // when
        var solution = new CountSubstringsWithOnlyOneDistinctLetter();

        // then
        assertThat(solution.countLetters("aaaba")).isEqualTo(8);
    }
}