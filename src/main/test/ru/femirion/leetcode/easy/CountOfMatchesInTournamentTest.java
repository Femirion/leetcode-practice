package ru.femirion.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CountOfMatchesInTournamentTest {
    @Test
    void check() {
        // when
        var solution = new CountOfMatchesInTournament();

        // then
        assertThat(solution.numberOfMatches(3)).isEqualTo(2);
    }
}