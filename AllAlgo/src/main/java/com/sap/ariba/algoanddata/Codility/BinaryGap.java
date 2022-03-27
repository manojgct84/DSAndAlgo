package com.sap.ariba.algoanddata.Codility;

public class BinaryGap
{

    public static void main (String[] args)
    {
        System.out.print("Solution " + solution(529));
    }

    public static int solution (int N)
    {
        // write your code  in Java SE 8

        if (N == 1) {
            return 0;
        }

        char[] binary = Integer.toBinaryString(N).toCharArray();
        int binaryGap = 0;
        int finalGap = 0;
        for (char bin : binary) {
            if (bin == '0') {
                binaryGap++;
            }
            else if (bin == '1') {
                {
                    finalGap = Math.max(binaryGap, finalGap);
                    binaryGap = 0;
                }
            }

        }

        return finalGap;

    }
}
