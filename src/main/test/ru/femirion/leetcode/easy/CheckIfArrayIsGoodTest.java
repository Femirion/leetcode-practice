package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CheckIfArrayIsGoodTest {
    @Test
    void isGood() {
        // when
        var solution = new CheckIfArrayIsGood();

        // then
//        assertThat(solution.isGood(new int[]{3, 4, 4, 1, 2, 1})).isEqualTo(true);
//        assertThat(solution.isGood(new int[]{2, 1, 3})).isEqualTo(false);
//        assertThat(solution.isGood(new int[]{2,2,2})).isEqualTo(false);
        assertThat(solution.isGood(new int[]{1, 3, 3, 2})).isEqualTo(true);
    }
}