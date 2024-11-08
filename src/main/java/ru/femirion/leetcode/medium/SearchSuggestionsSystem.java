package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 1268. Search Suggestions System
 * https://leetcode.com/problems/search-suggestions-system/description/
 */
public class SearchSuggestionsSystem {

    /**
     * Runtime 53 ms Beats 33.57%
     * Memory 51.07 MB Beats 12.37%
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Map<String, List<String>> trie = new HashMap<>();

        Arrays.sort(products);

        for (String product : products) {
            StringBuilder sb = new StringBuilder();
            for (char c : product.toCharArray()) {
                sb.append(c);
                String str = sb.toString();
                List<String> words = trie.getOrDefault(str, new ArrayList<>());
                if (words.size() < 3) {
                    words.add(product);
                    trie.put(str, words);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            sb.append(c);
            List<String> searched = new ArrayList<>();
            searched.addAll(trie.getOrDefault(sb.toString(), new ArrayList<>()));
            result.add(searched);
        }
        return result;
    }
}
