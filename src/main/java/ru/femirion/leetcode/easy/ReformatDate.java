package ru.femirion.leetcode.easy;

/**
 * 1507. Reformat Date
 * https://leetcode.com/problems/reformat-date/description/
 */
public class ReformatDate {

    private static final char F = 'F';
    private static final char M = 'M';
    private static final char A = 'A';
    private static final char J = 'J';
    private static final char S = 'S';
    private static final char O = 'O';
    private static final char N = 'N';
    private static final char D = 'D';
    private static final char ZERO = '0';
    private static final char NINE = '9';
    private static final String JAN = "01";
    private static final String FEB = "02";
    private static final String MAR = "03";
    private static final String APR = "04";
    private static final String MAY = "05";
    private static final String JUN = "06";
    private static final String JUL = "07";
    private static final String AUG = "08";
    private static final String SEP = "09";
    private static final String OCT = "10";
    private static final String NOV = "11";
    private static final String DEC = "12";

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.54 MB Beats 65.67% of users with Java
     */
    public String reformatDate(String date) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        char cur = date.charAt(0);
        while (ZERO <= cur && cur <= NINE) {
            result.append(cur);
            i++;
            cur = date.charAt(i);
        }

        if (result.length() == 1) {
            result.insert(0, "-0");
        } else {
            result.insert(0, '-');
        }

        // skip -rd whitespace
        i = i + 3;
        cur = date.charAt(i);
        switch (cur) {
            case F : {
                result.insert(0, FEB);
                break;
            }
            case M : {
                if (date.charAt(i + 2) == 'r') {
                    result.insert(0, MAR);
                } else {
                    result.insert(0, MAY);
                }
                break;
            }
            case A : {
                if (date.charAt(i + 2) == 'g') {
                    result.insert(0, AUG);
                } else {
                    result.insert(0, APR);
                }
                break;
            }
            case J : {
                if (date.charAt(i + 2) == 'n') {
                    if (date.charAt(i + 1) == 'a') {
                        result.insert(0, JAN);
                    } else {
                        result.insert(0, JUN);
                    }
                } else {
                    result.insert(0, JUL);
                }
                break;
            }
            case S : {
                result.insert(0, SEP);
                break;
            }
            case O : {
                result.insert(0, OCT);
                break;
            }
            case N : {
                result.insert(0, NOV);
                break;
            }
            case D : {
                result.insert(0, DEC);
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
