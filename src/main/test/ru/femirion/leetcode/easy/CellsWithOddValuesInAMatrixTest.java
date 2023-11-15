package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CellsWithOddValuesInAMatrixTest {
    @Test
    void check() {
        // when
        var solution = new CellsWithOddValuesInAMatrix();

        // then
        assertThat(solution.oddCells(48, 37, new int[][]{new int[]{40,5}})).isEqualTo(2);
    }
}