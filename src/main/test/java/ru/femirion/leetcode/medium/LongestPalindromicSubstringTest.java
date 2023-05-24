package ru.femirion.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LongestPalindromicSubstringTest {

    @Test
    void debug() {
        // when
        var solution = new LongestPalindromicSubstring();

        // then
        assertThat(solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth")).isEqualTo("abba");
    }

    @Test
    void check() {
        // when
        var solution = new LongestPalindromicSubstring();

        // then
        assertThat(solution.longestPalindrome("abba")).isEqualTo("abba");
        assertThat(solution.longestPalindrome("cbbd")).isEqualTo("bb");
        assertThat(solution.longestPalindrome("ac")).isEqualTo("a");
        assertThat(solution.longestPalindrome("baba")).isEqualTo("bab");
    }
}