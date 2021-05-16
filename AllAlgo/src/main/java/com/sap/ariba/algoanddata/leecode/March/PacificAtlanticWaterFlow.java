package com.ariba.sap.test.leecode.March;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * <p>
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * Note:
 * <p>
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * <p>
 * <p>
 * Example:
 * <p>
 * Given the following 5x5 matrix:
 * <p>
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * Atlantic
 * <p>
 * Return:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */

public class PacificAtlanticWaterFlow {

    public static void main(String args[]) {
        System.out.println(pacificAtlantic(new int[][]{{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}}));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            List<Integer> flow = new ArrayList<>();
            result.add(flow);
            return result;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
        }
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> flow = new ArrayList<>();
                    flow.add(i);
                    flow.add(j);
                    result.add(flow);
                }
            }
        return result;
    }

    static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int n = matrix.length, m = matrix[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height)
            return;

        visited[x][y] = true;

        for (int[] d : dir) {
            dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }
}
