package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IntersectionOfMultipleArraysTest {
    @Test
    void check() {
        // when
        var solution = new IntersectionOfMultipleArrays();

        // then
        assertThat(solution.intersection(new int[][] {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}})).isEqualTo(List.of(3, 4));
    }
}