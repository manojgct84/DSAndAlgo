package com.sap.ariba.algoanddata.Saleforce;

import java.util.ArrayList;
import java.util.List;

public class ConvertAdjacencyMatrixToList {

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1}, {0, 0, 1}, {1, 1, 0}};

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < matrix[0].length; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    adjacencyList.get(i).add(j);
                }
            }
        }
    }
}
