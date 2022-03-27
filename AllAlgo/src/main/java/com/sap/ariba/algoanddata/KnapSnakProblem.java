package com.sap.ariba.algoanddata;

public class KnapSnakProblem {

    private int solution(int[] val, int[] wt, int W, int N){

        if (N == 0) {
            return 0;
        }
        if (W == 0) {
            return 0;
        }

        if (wt[N] <= W) {
            int x = val[N] + solution(val, wt, W - wt[N], N - 1);
            int y = solution(val, wt, W, N - 1);
            return Math.max(x, y);
        }
        return solution(val, wt, W, N - 1);
    }


   public static void main (String[] args)
    {

    }
}
