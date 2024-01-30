package ru.femirion.leetcode.easy;

/**
 * 345. Reverse Vowels of a String
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 */
public class ReverseVowelsOfAString {

    /**
     * Runtime 3 ms Beats 79.74% of users with Java
     * Memory 44.87 MB Beats 45.91% of users with Java
     */
    public String reverseVowels(String s) {
        int p = 0;
        int q = s.length() - 1;
        char[] arr = s.toCharArray();
        while (p < q) {
            char pC = s.charAt(p);
            char qC = s.charAt(q);
            if (isAVowel(pC) && isAVowel(qC)) {
                arr[q] = pC;
                arr[p] = qC;
                p++;
                q--;
                continue;
            }
            if (!isAVowel(pC)) {
                arr[p] = pC;
                p++;
            }
            if (!isAVowel(qC)) {
                arr[q] = qC;
                q--;
            }
        }
        return new String(arr);
    }

    private boolean isAVowel(char e) {
        return e == 'a'
                ||  e == 'A'
                ||  e == 'e'
                ||  e == 'E'
                ||  e == 'i'
                ||  e == 'I'
                ||  e == 'o'
                ||  e == 'O'
                ||  e == 'u'
                ||  e == 'U';
    }


}
