package com.ariba.sap.test.leecode.Feb;

import java.util.*;

public class TheKWeakestRowsMatrix {
    /**
     * Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
     * <p>
     * A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: mat =
     * [[1,1,0,0,0],
     * [1,1,1,1,0],
     * [1,0,0,0,0],
     * [1,1,0,0,0],
     * [1,1,1,1,1]],
     * k = 3
     * Output: [2,0,3]
     * Explanation:
     * The number of soldiers for each row is:
     * row 0 -> 2
     * row 1 -> 4
     * row 2 -> 1
     * row 3 -> 2
     * row 4 -> 5
     * Rows ordered from the weakest to the strongest are [2,0,3,1,4]
     * Example 2:
     * <p>
     * Input: mat =
     * [[1,0,0,0],
     * [1,1,1,1],
     * [1,0,0,0],
     * [1,0,0,0]],
     * k = 2
     * Output: [0,2]
     * Explanation:
     * The number of soldiers for each row is:
     * row 0 -> 1
     * row 1 -> 4
     * row 2 -> 1
     * row 3 -> 1
     * Rows ordered from the weakest to the strongest are [0,2,3,1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == mat.length
     * n == mat[i].length
     * 2 <= n, m <= 100
     * 1 <= k <= m
     * matrix[i][j] is either 0 or 1.
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kWeakestRows(new int[][]{{1, 1, 0, 0, 0},
                                                                    {1, 1, 1, 1, 0},
                                                                    {1, 0, 0, 0, 0},
                                                                    {1, 1, 0, 0, 0},
                                                                    {1, 1, 1, 1, 1}},
                3)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {

        int y = mat.length, index = 0;
        int[] visited = new int[mat.length], ans = new int[k];
        for (int j = 0; j <= mat[0].length; j++) {
            for (int i = 0; i < y; i++) {
                if (visited[i] == 0 && (j == mat[0].length || mat[i][j] == 0)) {
                    ans[index++] = i;
                    visited[i]++;
                }
                if (index == k) return ans;
            }
        }
        return ans;
    }
}
