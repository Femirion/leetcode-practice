package ru.femirion.leetcode.easy;

/**
 * 3280. Convert Date to Binary
 * https://leetcode.com/problems/convert-date-to-binary/description/
 */
public class ConvertDateToBinary {

    /**
     * Runtime 3 ms Beats 88.71%
     * Memory 42.36 MB Beats 83.72%
     */
    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");
        StringBuilder sb = new StringBuilder();

        return sb.append(Integer.toBinaryString(Integer.valueOf(parts[0])))
                .append("-")
                .append(Integer.toBinaryString(Integer.valueOf(parts[1])))
                .append("-")
                .append(Integer.toBinaryString(Integer.valueOf(parts[2])))
                .toString();
    }
}
