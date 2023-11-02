package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SetMismatchTest {
    @Test
    void findErrorNums() {
        // given
        int[] errors = {1,2,2,4};
        SetMismatch solution = new SetMismatch();

        // when
        var result = solution.findErrorNums(errors);

        // then
        int[] expected = {2,3};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void findErrorNums2() {
        // given
        int[] errors = {2, 2};
        SetMismatch solution = new SetMismatch();

        // when
        var result = solution.findErrorNums(errors);

        // then
        int[] expected = {2,1};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void findErrorNums3() {
        // given
        int[] errors = {1, 1};
        SetMismatch solution = new SetMismatch();

        // when
        var result = solution.findErrorNums(errors);

        // then
        int[] expected = {1,2};
        assertThat(result).isEqualTo(expected);
    }
}