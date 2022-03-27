package com.sap.ariba.algoanddata;

public class NQueen
{

    private static int[][] queenTable;
    private static int numberOfQueens;

    public NQueen (int numberOfQueens)
    {
        queenTable = new int[numberOfQueens][numberOfQueens];
        NQueen.numberOfQueens = numberOfQueens;
    }

    private void solve ()
    {
        if (setQueen(0)) {
            printQueens();
        }
    }

    private void printQueens ()
    {
        for (int row = 0; row < numberOfQueens; row++) {
            for (int col = 0; col < numberOfQueens; col++) {
                System.out.print(queenTable[row][col] + " ");
            }
            System.out.println(" ");
        }
    }

    private static boolean setQueen (int queenColumn)
    {
        if (queenColumn == numberOfQueens) {
            return true;
        }

        for (int row = 0; row < numberOfQueens; row++) {

            if (isPlaceValid(row,queenColumn)) {
                queenTable[row][queenColumn] = 1;

                if (setQueen(queenColumn + 1)) {
                    return true;
                }
                queenTable[row][queenColumn] = 0;
            }
        }
        return false;
    }

    private static boolean isPlaceValid (int row, int queenColumn)
    {
        for (int colIndex = queenColumn; colIndex >= 0; --colIndex) {
            if (queenTable[row][colIndex] == 1) {
                return false;
            }
        }

        for (int i = row, j = queenColumn; i >= 0 && j >= 0; i--, j--) {
            if (queenTable[i][j] == 1) {
                return false;
            }
        }


        for (int i = row; i >= 0; i--) {
            if (queenTable[i][queenColumn] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main (String args[])
    {
        NQueen nQueen = new NQueen(5);
        nQueen.solve();
    }
}
