package ru.femirion.leetcode.easy;

/**
 * 1507. Reformat Date
 * https://leetcode.com/problems/reformat-date/description/
 */
public class ReformatDate {

    /**
     * Runtime 1 ms Beats 94.22% of users with Java
     * Memory 41.02 MB Beats 98.22% of users with Java
     */
    public String reformatDate(String date) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        char cur = date.charAt(0);
        while ('0' <= cur && cur <= '9') {
            result.append(cur);
            i++;
            cur = date.charAt(i);
        }

        if (result.length() == 1) {
            result.insert(0, '0');
        }

        result.insert(0, '-');
        // skip -rd whitespace
        i = i + 3;

        cur = date.charAt(i);
        switch (cur) {
            case 'F' : {
                result.insert(0, "02");
                break;
            }
            case 'M' : {
                if (date.charAt(i + 2) == 'r') {
                    result.insert(0, "03");
                } else {
                    result.insert(0, "05");
                }
                break;
            }
            case 'A' : {
                if (date.charAt(i + 2) == 'g') {
                    result.insert(0, "08");
                } else {
                    result.insert(0, "04");
                }
                break;
            }
            case 'J' : {
                if (date.charAt(i + 2) == 'n') {
                    if (date.charAt(i + 1) == 'a') {
                        result.insert(0, "01");
                    } else {
                        result.insert(0, "06");
                    }
                } else {
                    result.insert(0, "07");
                }
                break;
            }
            case 'S' : {
                result.insert(0, "09");
                break;
            }
            case 'O' : {
                result.insert(0, "10");
                break;
            }
            case 'N' : {
                result.insert(0, "11");
                break;
            }
            case 'D' : {
                result.insert(0, "12");
                break;
            }
        }

        result.insert(0, '-');
        // skip month and whitespace
        i = i + 4;

        result.insert(0, date.substring(i));
        return result.toString();
    }
}
