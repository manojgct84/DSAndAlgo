package com.sap.ariba.algoanddata;

public class MatrixAllPath
{

    public static void main (String[] args)
    {
        matrixAllPath(3,3);
    }

    private static void matrixAllPath (int row,
                                       int col)
    {
        int[][] count = new int[row][col];

        for (int i = 0; i < row; i++) {
            count[i][0] = 1;
        }
        for (int i = 0; i < col; i++) {
            count[0][i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1];
            }
        }
        System.out.println(count[row - 1][col - 1]);
    }
}
