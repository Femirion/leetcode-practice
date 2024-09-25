package ru.femirion.leetcode.hard;

/**
 * 2416. Sum of Prefix Scores of Strings
 * https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description/
 */
public class SumOfPrefixScoresOfStrings {

    /**
     * Runtime 331 ms Beats 36.13%
     * Memory 187.16 MB Beats 76.77%
     */
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            fillTrie(trie, word);
        }

        Trie curTrie = trie;
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                if (curTrie.nodes[c - 'a'] != null) {
                    result[i] = result[i] + curTrie.nodes[c - 'a'].count;
                    curTrie = curTrie.nodes[c - 'a'];
                } else {
                    curTrie = trie;
                    break;
                }
            }
            curTrie = trie;
        }
        return result;
    }

    private void fillTrie(Trie trie, String word) {
        Trie curTrie = trie;
        for (char c : word.toCharArray()) {
            if (curTrie.nodes[c - 'a'] == null) {
                curTrie.nodes[c - 'a'] = new Trie();
                curTrie.nodes[c - 'a'].count = 1;
            } else {
                curTrie.nodes[c - 'a'].count++;
            }
            curTrie = curTrie.nodes[c - 'a'];
        }
    }

    private static class Trie {
        Trie[] nodes = new Trie[26];
        int count = 0;
    }
}
