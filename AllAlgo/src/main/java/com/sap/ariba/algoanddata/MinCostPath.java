package com.sap.ariba.algoanddata;

public class MinCostPath
{
    private  void minCost(int[][] cost, int row, int col){
        int temp[][] = new int[row][col];

        int sum = 0;
        for (int i = 0; i < col; i++) {
            temp[0][i] = sum + cost[0][i];
            sum = temp[0][i];
        }

        sum = 0;
        for (int i = 0; i < row; i++) {
            temp[i][0] = sum + cost[i][0];
            sum = temp[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                 temp[i][j]= cost[i][j] + minCheck(temp[i-1][j-1],temp[i-1][j],temp[i][j-1]);
            }
        }
        display(temp,row,col);
    }

    private void display (int[][] temp,
                          int row,
                          int col)
    {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private int minCheck (int topLeft,int topRight,int left)
    {
        int min = Math.min(topLeft,topRight);
        return Math.min(min,left);
    }

    public static void main(String args[]){
        MinCostPath mcp = new MinCostPath();
        int cost[][] = {{1,2,3},
                        {4,8,2},
                        {1,5,3},
                        {6,2,9}};
        mcp.minCost(cost,4,3);
    }
}
