package ru.femirion.leetcode.easy;

/**
 * 657. Robot Return to Origin
 * https://leetcode.com/problems/robot-return-to-origin/
 */
public class RobotReturnToOrigin {

    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char UP = 'U';
    private static final char DOWN = 'D';

    /**
     * Runtime 6ms Beats 54.38% of users with Java
     * Memory 43.62MB Beats 22.86% of users with Java
     */
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == LEFT) {
                x--;
                continue;
            }
            if (moves.charAt(i) == RIGHT) {
                x++;
                continue;
            }
            if (moves.charAt(i) == UP) {
                y++;
                continue;
            }
            if (moves.charAt(i) == DOWN) {
                y--;
            }
        }
        return x == 0 && y == 0;
    }

}
