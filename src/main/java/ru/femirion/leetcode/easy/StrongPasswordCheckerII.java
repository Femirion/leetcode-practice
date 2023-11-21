package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2299. Strong Password Checker II
 * https://leetcode.com/problems/strong-password-checker-ii/description/
 */
public class StrongPasswordCheckerII {

    private static final Set<Character> DIGIT = getDigit();
    private static final Set<Character> SPECIAL = getSpecial();
    private static final Set<Character> LOWERCASE = getLowercase();
    private static final Set<Character> UPPERCASE = getUppercase();

    /**
     * Runtime 1ms Beats 82.93% of users with Java
     * Memory 40.82MB Beats 15.61% of users with Java
     */
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasOneDigit = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            char current = password.charAt(i);
            if (i != 0 && i != password.length() - 1) {
                if (password.charAt(i - 1) == current || password.charAt(i + 1) == current) {
                    return false;
                }
            }
            if (DIGIT.contains(current)) {
                hasOneDigit = true;
                continue;
            }
            if (LOWERCASE.contains(current)) {
                hasLowerCase = true;
                continue;
            }
            if (SPECIAL.contains(current)) {
                hasSpecial = true;
                continue;
            }
            if (UPPERCASE.contains(current)) {
                hasUpperCase = true;
                continue;
            }
        }
        return hasLowerCase && hasOneDigit && hasUpperCase && hasSpecial;
    }

    private static Set<Character> getUppercase() {
        Set<Character> result = new HashSet<>();
        result.add('A');
        result.add('B');
        result.add('C');
        result.add('D');
        result.add('E');
        result.add('F');
        result.add('G');
        result.add('H');
        result.add('I');
        result.add('J');
        result.add('K');
        result.add('L');
        result.add('M');
        result.add('N');
        result.add('O');
        result.add('P');
        result.add('Q');
        result.add('R');
        result.add('S');
        result.add('T');
        result.add('U');
        result.add('V');
        result.add('W');
        result.add('X');
        result.add('Y');
        result.add('Z');
        return result;
    }

    private static Set<Character> getLowercase() {
        Set<Character> result = new HashSet<>();
        result.add('a');
        result.add('b');
        result.add('c');
        result.add('d');
        result.add('e');
        result.add('f');
        result.add('g');
        result.add('h');
        result.add('i');
        result.add('j');
        result.add('k');
        result.add('l');
        result.add('m');
        result.add('n');
        result.add('o');
        result.add('p');
        result.add('q');
        result.add('r');
        result.add('s');
        result.add('t');
        result.add('u');
        result.add('v');
        result.add('w');
        result.add('x');
        result.add('y');
        result.add('z');
        return result;
    }

    private static Set<Character> getDigit() {
        Set<Character> result = new HashSet<>();
        result.add('1');
        result.add('2');
        result.add('3');
        result.add('4');
        result.add('5');
        result.add('6');
        result.add('7');
        result.add('8');
        result.add('9');
        result.add('0');
        return result;
    }

    private static Set<Character> getSpecial() {
        Set<Character> result = new HashSet<>();
        result.add('!');
        result.add('@');
        result.add('#');
        result.add('$');
        result.add('%');
        result.add('^');
        result.add('&');
        result.add('*');
        result.add('(');
        result.add(')');
        result.add('-');
        result.add('+');
        return result;
    }

}
