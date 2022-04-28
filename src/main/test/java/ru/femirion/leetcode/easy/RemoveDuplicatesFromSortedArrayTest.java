package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RemoveDuplicatesFromSortedArrayTest {

    @Test
    void check() {
        // when
        var solution = new RemoveDuplicatesFromSortedArray();

        // then
        int[] x = {1, 2, 2, 2, 2, 3, 4};
        assertThat(solution.removeDuplicates(x)).isEqualTo(4);
    }
}