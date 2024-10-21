package ru.femirion.leetcode.easy;

/**
 * 1108. Defanging an IP Address
 * https://leetcode.com/problems/defanging-an-ip-address/description/
 */
public class DefangingAnIPAddress {

    private static final String NEW_DELIMITER = "[.]";

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.57 MB Beats 45.42%
     */
    public String defangIPaddr2(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append(NEW_DELIMITER);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Runtime 1 ms Beats 46.09%
     * Memory 40.99 MB Beats 97.89%
     */
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "\\[\\.\\]");
    }
}
