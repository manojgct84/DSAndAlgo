package com.sap.ariba.algoanddata;

public class StaircaseProblem
{

    public static void main (String[] args)
    {
        howMayWaysToClimbTop(5);
    }

    private static void howMayWaysToClimbTop (int n)
    {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println("dp " + dp[n - 1]);
    }
}
