package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 535. Encode and Decode TinyURL
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 */
public class EncodeAndDecodeTinyURL {

    private Map<String, String> urls = new HashMap<>();

    /**
     * Runtime 2 ms Beats 70.03%
     * Memory 43.14 MB Beats 29.15%
     */
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hash = hashTheValue(longUrl);
        while(urls.get(hash) != null) {
            hash = hash + "1";
        }
        urls.put(hash, longUrl);
        return hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urls.get(shortUrl);
    }

    private String hashTheValue(String str) {
        return Integer.toString(Objects.hashCode(str));
    }
}
