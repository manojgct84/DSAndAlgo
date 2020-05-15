package com.sap.ariba.algoanddata;

public class HourGlass
{
    // Complete the hourglassSum function below.
    static int hourglassSum (int[][] arr)
    {
        int max_sum = Integer.MIN_VALUE;
        int tempMax = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i + 2 < 6 && j + 2 < 6) {
                    tempMax += arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                    tempMax += arr[i + 1][j + 1];
                    tempMax += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                    if (max_sum < tempMax) {
                        max_sum = tempMax;
                    }

                    tempMax = 0;
                }
            }
        }
        return max_sum;
    }

    public static void main (String args[])
    {
        int[][] arr = { { 1, 1, 1, 0, 0, 0 }, { 0, 2, 0, 0, 0, 0 }, { 2, 2, 3, 0, 0, 0 },
                        { 1, 1, 1, 0, 0, 0 }, { 0, 2, 0, 0, 0, 0 }, { 2, 2, 3, 0, 0, 0 } };

        System.out.println(hourglassSum(arr));
    }
}
