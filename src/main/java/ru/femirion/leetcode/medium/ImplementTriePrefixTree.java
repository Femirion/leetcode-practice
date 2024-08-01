package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */
public class ImplementTriePrefixTree {

    Map<Character, Item> items = new HashMap<>();

    /**
     * Runtime 42 ms Beats  31.33%
     * Memory 55.24 MB Beats 49.39%
     */
    public void insert(String word) {
        Item item;
        Map<Character, Item> tmp = items;
        boolean end = false;
        for (int i = 0; i < word.length(); i++) {
            item = tmp.get(word.charAt(i));
            if (i == word.length() - 1) {
                end = true;
            }
            if (item == null) {
                item = new Item(word.charAt(i), new HashMap<>(), end);
                tmp.put(word.charAt(i), item);
            } else {
                if (end) {
                    item.end = true;
                }
            }
            tmp = item.items;
        }
        var x = items;
        var y = 0;
    }

    public boolean search(String word) {
        Item item;
        Map<Character, Item> tmp = items;
        for (int i = 0; i < word.length(); i++) {
            item = tmp.get(word.charAt(i));
            if (item == null) {
                return false;
            }
            if (i == word.length() - 1) {
                var x = item.end;
                return item.end;
            }
            tmp = item.items;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Item item;
        Map<Character, Item> tmp = items;
        for (int i = 0; i < prefix.length(); i++) {
            item = tmp.get(prefix.charAt(i));
            if (item == null) {
                return false;
            }
            tmp = item.items;
        }
        return true;
    }

    private static class Item {
        private char e;
        private Map<Character, Item> items;
        private boolean end;

        public Item(char e, Map<Character, Item> items, boolean end) {
            this.e = e;
            this.items = items;
            this.end = end;
        }

        public String toString() {
            return "e=" + e + ", items=" + items + ", end=" + end;
        }
    }
}
