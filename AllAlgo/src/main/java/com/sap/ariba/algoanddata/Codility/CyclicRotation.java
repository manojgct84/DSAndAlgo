package com.sap.ariba.algoanddata.Codility;

public class CyclicRotation
{
    public static void main (String args[])
    {
        solution(new int[] { 3, 8, 9, 7, 6 },
                 3);
    }

    public static int[] solution (int[] N,
                                  int K)
    {

        if (N.length == 0) {
            return N;
        }
        if (N.length == 1) {
            return N;
        }

        for (int i = 0; i < K; i++) {
            int temp = N[N.length - 1];
            int j = N.length - 1;
            while (j > 0) {
                N[j] = N[j - 1];
                j--;
            }
            N[j] = temp;
        }
        System.out.println(N);
        return N;
    }
}
