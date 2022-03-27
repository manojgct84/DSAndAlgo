package com.sap.ariba.algoanddata;

public class ArrayManipulation
{
    static long arrayManipulation (int queries[][],
                                   int n)
    {
        int[] outArray = new int[n + 2];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int c = queries[i][2];
            outArray[a] += c;
            outArray[b + 1] -= c;
        }

        return getMax(outArray);
    }

    private static long getMax (int[] inputArray)
    {
        int sum = 0;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < inputArray.length; i++) {
            sum  += inputArray[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main (String[] args)
    {
        int S = 3;
        int a[][] = { { 1, 3, 1 } };
        int n = a.length;

        System.out.println(arrayManipulation(a,
                                             S));
    }
}
