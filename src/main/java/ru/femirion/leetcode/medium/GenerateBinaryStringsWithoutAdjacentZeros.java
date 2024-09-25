package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 3211. Generate Binary Strings Without Adjacent Zeros
 * https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description/
 */
public class GenerateBinaryStringsWithoutAdjacentZeros {

    /**
     * Runtime 3 ms Beats 74.21%
     * Memory 45.64 MB Beats 60.88%
     */
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 1, n);
        return result;
    }

    private void generate(List<String> result, String tmp, int lastVal, int n) {
        if (tmp.length() == n) {
            result.add(tmp);
            return;
        }

        if (lastVal == 1) {
            generate(result, tmp + "0", 0, n);
        }
        generate(result, tmp + "1", 1, n);
    }
}
