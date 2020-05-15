package com.sap.ariba.algoanddata;

public class EqualStacks
{
    static int equalStacks (int[] h1,
                            int[] h2,
                            int[] h3)
    {
        /*
         * Write your code here.
         */

        int i = 0, j = 0, k = 0;
        int sum1 = calculate(h1), sum2 = calculate(h2), sum3 = calculate(h3);
        while (true) {

            if (sum1 > sum2 || sum1 > sum3) {
                sum1 -= h1[i++];
            }
            if (sum2 > sum1 || sum2 > sum3) {
                sum2 -= h2[j++];
            }
            if (sum3 > sum1 || sum3 > sum1) {
                sum3 -= h3[k++];
            }

            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

        }
    }

    private static int calculate (int[] h)
    {
        int sum = 0;
        for (int i = 0; i < h.length; i++) {
            sum += h[i];
        }
        return sum;
    }

    public static void main (String args[])
    {
        System.out.print(equalStacks(new int[] { 3, 2, 1, 1, 1 },
                                     new int[] { 4, 3, 2 },
                                     new int[] { 1, 1, 4, 1 }));
    }

}
