package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ValidParenthesesTest {
    @Test
    void check() {
        // when
        var solution = new ValidParentheses();

        // then
        assertThat(solution.isValid("()")).isEqualTo(true);
    }
}