package com.sap.ariba.algoanddata;

public class CoinChange {
    public static void main(String args[]) {
        // System.out.println(prod(1,4));
        // System.out.println(Solution.coinChange(4,new int[] { 1, 2, 3 },0));
        fibonacci(1,
                13,
                6,
                10);
    }

    private static int prod(int m,
                            int n) {
        if (m == n) {
            return n;
        } else {
            int recurse = prod(m,
                    n - 1);
            System.out.println(recurse);
            int result = n + recurse;
            return result;
        }
    }

    private static int fibonacci(int f1,
                                 int f6,
                                 int count,
                                 int fr) {
        // 1 0  , 6 13.
        if (count > f1) {
            return 2 * fibonacci(f1,
                    f6,
                    --count,
                    fr) + fibonacci(f1,
                    f6,
                    --count,
                    fr);
        } else {
            System.out.println(f1);
            return f1;
        }
    }
}

class Solution {

    public static int coinChange(int coin, int coins[], int index) {

        if (coin < 0) {
            return 0;
        }
        if (coin == 0) {
            return 1;
        }

        if (coins.length == index) {
            return 0;
        }
        int coin_index = coinChange(coin - coins[index], coins, index);
        System.out.println("result " + coin_index);
        int result = coin_index + coinChange(coin, coins, index + 1);
        System.out.println("result1 " + result);

        return result;
    }

    public int coinChange(int[] coins, int amount) {
        int result = 0;
        while (amount != 0) {
            for (int i = coins.length - 1; i >= 0; i--) {
                if (coins[i] <= amount) {
                    amount = amount - coins[i];
                    System.out.println("Adding " + coins[i]);
                    i++;
                    result++;
                }
            }
        }
        return result;
    }

    //Better solution
    int coinChangeProblem(int[] coins, int amount) {

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