package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OddStringDifferenceTest {
    @Test
    void check() {
        // when
        var solution = new OddStringDifference();

        // then
        assertThat(solution.oddString(new String[]{"wwe","yyg","ssa","ttb","ddd","ssa","xxf","ssa","ttb","xxf","xxf","zzh","wwe","yyg","xxf"}))
                .isEqualTo("ddd");
    }
}