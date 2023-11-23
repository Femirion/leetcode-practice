package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CountElementsWithStrictlySmallerAndGreaterElementsTest {
    @Test
    void check() {
        // when
        var solution = new CountElementsWithStrictlySmallerAndGreaterElements();

        // then
        assertThat(solution.countElements(new int[]{11,7,2,15})).isEqualTo(2);
    }
}