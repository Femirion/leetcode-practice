package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 * https://leetcode.com/problems/unique-email-addresses/
 */
public class UniqueEmailAddresses {

    /**
     * Runtime 11ms Beats 73.43%of users with Java
     * Memory 44.18MB Beats 43.90%of users with Java
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String[] tmp = emails[i].split("@");
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < tmp[0].length(); j++) {
                char current = tmp[0].charAt(j);
                if (current == '.') {
                    continue;
                }
                if (current == '+') {
                    break;
                }
                sb.append(current);
            }
            emailSet.add(sb.append(tmp[1]).toString());
        }
        return emailSet.size();
    }

}
