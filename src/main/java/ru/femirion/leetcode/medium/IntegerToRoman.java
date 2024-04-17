package ru.femirion.leetcode.medium;

/**
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/description/
 */
public class IntegerToRoman {

    /**
     * Runtime 3 ms Beats 97.26% of users with Java
     * Memory 44.37 MB Beats 54.61% of users with Java
     */
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        int thousands = num % 1000;
        if (thousands > 0) {
            result.append(getThousand(thousands));
            num = num - (thousands * 1000);
        }

        int handrids = num / 100;
        if (handrids > 0) {
            result.append(getHandreds(handrids));
            num = num - (handrids * 100);
        }

        int decades = num % 10;
        if (decades > 0) {
            result.append(getDecades(decades));
            num = num - (decades * 10);
        }

        result.append(getBits(num));

        return result.toString();
    }

    private String getBits(int dec) {
        switch (dec) {
            case 1 -> {
                return "I";
            }
            case 2 -> {
                return "II";
            }
            case 3 -> {
                return "III";
            }
            case 4 -> {
                return "IV";
            }
            case 5 -> {
                return "V";
            }
            case 6 -> {
                return "VI";
            }
            case 7 -> {
                return "VII";
            }
            case 8 -> {
                return "VIII";
            }
            case 9 -> {
                return "IX";
            }
            case 0 -> {
                return "";
            }
        }
        return "";
    }

    private String getDecades(int th) {
        switch (th) {
            case 1 -> {
                return "X";
            }
            case 2 -> {
                return "XX";
            }
            case 3 -> {
                return "XXX";
            }
            case 4 -> {
                return "XL";
            }
            case 5 -> {
                return "L";
            }
            case 6 -> {
                return "LX";
            }
            case 7 -> {
                return "LXX";
            }
            case 8 -> {
                return "LXXX";
            }
            case 9 -> {
                return "XC";
            }
            case 0 -> {
                return "";
            }
        }
        return "";
    }

    private String getHandreds(int th) {
        switch (th) {
            case 1 -> {
                return "C";
            }
            case 2 -> {
                return "CC";
            }
            case 3 -> {
                return "CCC";
            }
            case 4 -> {
                return "CD";
            }
            case 5 -> {
                return "D";
            }
            case 6 -> {
                return "DC";
            }
            case 7 -> {
                return "DCC";
            }
            case 8 -> {
                return "DCCC";
            }
            case 9 -> {
                return "CM";
            }
            case 0 -> {
                return "";
            }
        }
        return "";
    }

    private String getThousand(int th) {
        switch (th) {
            case 1 -> {
                return "M";
            }
            case 2 -> {
                return "MM";
            }
            case 3 -> {
                return "MMM";
            }
        }
        return "";
    }


}
