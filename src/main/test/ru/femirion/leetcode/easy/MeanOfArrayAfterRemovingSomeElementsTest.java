package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MeanOfArrayAfterRemovingSomeElementsTest {
    @Test
    void check() {
        // when
        var solution = new MeanOfArrayAfterRemovingSomeElements();

        // then
//        assertThat(solution.trimMean(new int[]{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3})).isEqualTo(2.00000);
        assertThat(solution.trimMean(new int[]{6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4})).isEqualTo(4.77778);
    }
}