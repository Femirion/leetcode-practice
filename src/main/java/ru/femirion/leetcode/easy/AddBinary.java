package ru.femirion.leetcode.easy;

/**
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/description/
 */
public class AddBinary {

    /**
     * Runtime 2 ms Beats 58.31% of users with Java
     * Memory 42.27 MB Beats 50.60% of users with Java
     */
    public String addBinary(String a, String b) {
        int p = a.length() - 1;
        int q = b.length() - 1;
        byte aV = 0;
        byte bV = 0;
        boolean additional = false;

        StringBuilder sb = new StringBuilder();

        while(p >= 0 || q >= 0) {
            if (p < 0) {
                aV = 0;
            } else {
                aV = (byte) (a.charAt(p) - '0');
            }

            if (q < 0) {
                bV = 0;
            } else {
                bV = (byte) (b.charAt(q) - '0');
            }

            p--;
            q--;

            if (bV == 1 && aV == 1) {
                if (!additional) {
                    additional = true;
                    sb.append('0');
                } else {
                    additional = true;
                    sb.append('1');
                }
                continue;
            }

            if (bV == 1 || aV == 1) {
                if (!additional) {
                    sb.append('1');
                } else {
                    additional = true;
                    sb.append('0');
                }
                continue;
            }

            if (bV == 0 && aV == 0) {
                if (!additional) {
                    sb.append('0');
                } else {
                    additional = false;
                    sb.append('1');
                }
            }
        }

        if (additional) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}
