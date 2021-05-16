package com.ariba.sap.test.leecode.March;

public class CoinChange {

    public static void main(String[] args) {
        coinChangeProblem(new int[]{1,3,5}, 11);
    }

    private static int coinChangeProblem(int[] coins, int amount) {

        int totalCoins = coins.length;

        // Creating array which stores subproblems' solutions
        double[][] arr = new double[totalCoins + 1][amount + 1];

        // Initialising first row with +ve infinity
        for (int j = 0; j <= amount; j++) {
            arr[0][j] = Double.POSITIVE_INFINITY;
        }

        // Initialising first column with 0
        for (int i = 1; i <= totalCoins; i++) {
            arr[i][0] = 0;
        }

        // Implementing the recursive solution
        for (int i = 1; i <= totalCoins; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j)
                    arr[i][j] = Math.min(1 + arr[i][j - coins[i - 1]], arr[i - 1][j]);
                else
                    arr[i][j] = arr[i - 1][j];
            }
        }

        int result = (int) arr[totalCoins][amount];
        return result <= amount ? result : -1;
    }

}
