package com.sap.ariba.algoanddata.Codility;

public class FairIndexProblem
{

    public static void main (String args[])
    {
        System.out.println(fairIndex(new int[] { 4, -1, 0, 3 },
                                     new int[] { -2, 5, 0, 3 }));
    }

    public static int solution (int[] a,
                                int[] b)
    {
        int addA = 0;
        int addB = 0;

        if (a.length != b.length) {
            return 0;
        }

        if (a.length != b.length) {
            return 0;
        }

        for (int i = 0; i < a.length; i++) {
            addA += a[i];
            addB += b[i];
        }

        int reAddA = 0;
        int reAddB = 0;

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            reAddA += a[i];
            reAddB += b[i];
            addA -= a[i];
            addB -= b[i];

            if (addB == addA && reAddA == reAddB && addB == reAddB) {
                result++;
            }
        }

        return result;
    }

    public static int solution1 (int[] a,
                                 int[] b)
    {
        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];
        }

        int curSumA = 0;
        int curSumB = 0;

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            curSumA += a[i];
            curSumB += b[i];
            sumA -= a[i];
            sumB -= b[i];

            if (sumA == sumB && curSumA == curSumB && sumA == curSumB) {
                result++;
            }
        }

        return result;
    }

    public static int fairIndex (int a[],
                                 int b[])
    {
        int sumA = 0;
        int sumB = 0;

        if(a.length != b.length) {
            return 0;
        }

        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];
        }

        int result = 0;
        int currentA = a[0];
        int currentB = b[0];
        for (int i = 1; i < a.length; i++) {
            if (i != 1 && currentA == currentB && 2 * currentA == sumA && 2 * currentA == sumB) {
                result++;
            }
            currentA += a[i];
            currentB += b[i];
        }
        return result;
    }
}
