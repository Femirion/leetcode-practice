package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SumOfDigitsOfStringAfterConvertTest {
    @Test
    void check() {
        // given
        SumOfDigitsOfStringAfterConvert solution = new SumOfDigitsOfStringAfterConvert();

        // then
        assertThat(solution.getLucky("iiii", 1)).isEqualTo(36);
    }
}