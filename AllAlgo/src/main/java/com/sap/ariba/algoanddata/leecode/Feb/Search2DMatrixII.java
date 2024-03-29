package com.sap.ariba.algoanddata.leecode.Feb;

public class Search2DMatrixII {

    /**
     * Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
     * <p>
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
     * Output: true
     * Example 2:
     * <p>
     * <p>
     * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
     * Output: false
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= n, m <= 300
     * -109 <= matix[i][j] <= 109
     * All the integers in each row are sorted in ascending order.
     * All the integers in each column are sorted in ascending order.
     * -109 <= target <= 109
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;

        int i = m;
        int j = 0;

        while (i >= 0 && j <= n) {
            if (target < matrix[i][j]) {
                i--;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
