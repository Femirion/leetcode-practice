package ru.femirion.leetcode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 271. Encode and Decode Strings
 * https://leetcode.com/problems/encode-and-decode-strings/description/
 */
public class EncodeAndDecodeStrings {

    /**
     * Runtime 13 ms Beats 31.80% of users with Java
     * Memory 45.76 MB Beats 12.82% of users with Java
     */
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String tmp = "".equals(strs.get(i)) ? "-><-" : strs.get(i);
            sb.append(tmp);
            if (i != strs.size() - 1) {
                sb.append("-<>-");
            }
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] arr = s.split("-<>-");
        return Arrays.stream(arr)
                .map(str -> "-><-".equals(str) ? "" : str)
                .collect(Collectors.toList());
    }
}
