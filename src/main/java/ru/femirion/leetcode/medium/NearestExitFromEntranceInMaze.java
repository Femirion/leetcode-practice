package ru.femirion.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1926. Nearest Exit from Entrance in Maze
 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/
 */
public class NearestExitFromEntranceInMaze {

    /**
     * Runtime 7 ms Beats 71.96%
     * Memory 44.90 MB Beats 99.75%
     */
    public int nearestExit(char[][] maze, int[] entrance) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curDist = cur[2];

            for (int i = 0; i < 4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if (newX == -1 || newY == -1 || newX == maze.length || newY == maze[curX].length) {
                    continue;
                }
                if (maze[newX][newY] == '+') {
                    continue;
                }
                if (newX == 0 || newY == 0 || newX == maze.length - 1 || newY == maze[curX].length - 1) {
                    return curDist + 1;
                }
                maze[newX][newY] = '+';
                queue.add(new int[]{newX, newY, curDist + 1});
            }
        }

        return -1;
    }
}
