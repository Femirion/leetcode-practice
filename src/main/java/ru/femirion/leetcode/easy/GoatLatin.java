package ru.femirion.leetcode.easy;

/**
 * 824. Goat Latin
 * https://leetcode.com/problems/goat-latin/
 */
public class GoatLatin {

    /**
     * Runtime Beats 79.86%of users with Java
     * Memory 40.84MB Beats 71.75%of users with Java
     */
    public String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        int counter = 1;
        char consonant = ' ';
        boolean beginsFromVowel = false;
        boolean firstLetter = true;
        for (int i = 0; i < sentence.length(); i++) {
            char current = sentence.charAt(i);
            if (current == ' ' || i == sentence.length() - 1) {
                if (i == sentence.length() - 1) {
                    tmp.append(current);
                    if (consonant == ' ') {
                        if (isVowel(current)) {
                            beginsFromVowel = true;
                        } else {
                            consonant = current;
                        }
                    }
                }
                if (beginsFromVowel) {
                    tmp.append("ma");
                } else {
                    tmp.deleteCharAt(0);
                    tmp.append(consonant);
                    tmp.append("ma");
                }
                for (int j = 0; j < counter; j++) {
                    tmp.append("a");
                }
                counter++;
                firstLetter = true;
                beginsFromVowel = false;
                consonant = ' ';
                result.append(tmp);
                if (i != sentence.length() - 1) {
                    result.append(" ");
                }
                tmp.delete(0, tmp.length());
            } else {
                if (firstLetter) {
                    if (isVowel(current)) {
                        beginsFromVowel = true;
                    } else {
                        consonant = current;
                    }
                    firstLetter = false;
                }
                tmp.append(sentence.charAt(i));
            }
        }
        return result.toString();
    }

    private boolean isVowel(char latter) {
        return switch (latter) {
            case 'A', 'a', 'U', 'u', 'O', 'o', 'I', 'i', 'E', 'e' -> true;
            default -> false;
        };
    }

}
