package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RemoveDigitFromNumberToMaximizeResultTest {
    @Test
    void check() {
        // when
        var solution = new RemoveDigitFromNumberToMaximizeResult();

        // then
        assertThat(solution.removeDigit("1231", '1')).isEqualTo("231");
        assertThat(solution.removeDigit("2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471", '3')).isEqualTo("231");
    }
}