package com.ariba.sap.test.leecode.Feb;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    /**
     * In an N by N square grid, each cell is either empty (0) or blocked (1).
     * <p>
     * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
     * <p>
     * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
     * C_1 is at location (0, 0) (ie. has value grid[0][0])
     * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
     * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
     * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [[0,1],[1,0]]
     * <p>
     * <p>
     * Output: 2
     * <p>
     * Example 2:
     * <p>
     * Input: [[0,0,0],[1,1,0],[1,1,0]]
     * <p>
     * <p>
     * Output: 4
     * <p>
     * <p>
     * <p>
     * Note:
     * <p>
     * 1 <= grid.length == grid[0].length <= 100
     * grid[r][c] is 0 or 1
     */

    //Breadth first search to find the shortest path.
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }

        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int path = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] p = q.poll();
                int currentI = p[0];
                int currentJ = p[1];
                if (currentI == grid.length - 1 && currentJ == grid[0].length - 1) {
                    return path;
                }
                for (int[] dist : directions) {
                    int X = currentI + dist[0];
                    int Y = currentJ + dist[1];

                    if (X < 0 || X > grid.length - 1 || Y < 0 || Y > grid[0].length - 1 || grid[X][Y] == 1 || visited[X][Y]) {
                        continue;
                    }
                    q.add(new int[]{X, Y});
                    visited[X][Y] = true;
                }
            }
            path++;
        }
        return -1;
    }
}
