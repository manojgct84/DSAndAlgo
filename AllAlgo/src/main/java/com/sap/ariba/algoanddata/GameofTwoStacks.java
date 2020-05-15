package com.sap.ariba.algoanddata;

public class GameofTwoStacks
{
    static int twoStacks (int x,
                          int[] a,
                          int[] b)
    {
        /*
         * Write your code here.
         */

        int j = 0;
        int runningSum = 0;
        while (j < a.length && runningSum + a[j] <= x) {
            runningSum += a[j];
            j++;
        }

        int max = j;
        for (int i = 1; i < b.length; i++) {
            runningSum += b[i - 1];

            while (runningSum > x && j > 0) {
                j--;
                runningSum -= a[j];
            }

            if (runningSum > x) {
                break;
            }

            max = Math.max(max,
                           i + j);
        }
        return max;
    }

    public static void main (String args[])
    {
        System.out.println(twoStacks(62,
                                     new int[] { 7, 15, 12, 0, 5, 18, 17, 2, 10, 15, 4, 2, 9, 15,
                                                     13, 12, 16 },
                                     new int[] { 12, 16, 6, 8, 16, 15, 18, 3, 11, 0, 17, 7, 6, 11,
                                                     14, 13, 15, 6, 18, 6, 16, 12, 16, 11, 16,
                                                     11 }));
    }

}
