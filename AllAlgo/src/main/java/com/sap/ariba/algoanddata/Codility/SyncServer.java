package com.sap.ariba.algoanddata.Codility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SyncServer
{

    private static int gridlength = 0;

    public static void main (String args[])
    {

        List<List<Integer>> mainList = new ArrayList<List<Integer>>();
        mainList.add(new ArrayList<>());
        mainList.get(0).add(0);
        mainList.get(0).add(0);
        mainList.get(0).add(0);
        mainList.get(0).add(0);

        mainList.add(new ArrayList<>());
        mainList.get(1).add(0);
        mainList.get(1).add(0);
        mainList.get(1).add(0);
        mainList.get(1).add(0);

        mainList.add(new ArrayList<>());
        mainList.get(2).add(0);
        mainList.get(2).add(0);
        mainList.get(2).add(0);
        mainList.get(2).add(0);

        mainList.add(new ArrayList<>());
        mainList.get(3).add(1);
        mainList.get(3).add(0);
        mainList.get(3).add(0);
        mainList.get(3).add(0);

        mainList.add(new ArrayList<>());
        mainList.get(4).add(0);
        mainList.get(4).add(0);
        mainList.get(4).add(0);
        mainList.get(4).add(0);

        SyncServer server = new SyncServer();
        gridlength = mainList.size();
        System.out.println(server.numberAmazonServerFile(5,
                                                         4,
                                                         mainList));

    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int numberAmazonServerFile (int rows,
                                int column,
                                List<List<Integer>> grid)
    {
        List<List<Integer>> solution = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            List<Integer> solCol = new ArrayList<>();
            for (int col = 0; col < column; col++) {
                solCol.add(0);
            }
            solution.add(solCol);
        }

        int result = 0;

        for (int hours = 0; hours < 2; hours++) {
            for (int row = 0; row < grid.size(); row++) {
                for (int col = 0; col < grid.get(row).size(); col++) {
                    if (safeToMove(grid,
                                   row,
                                   col,
                                   rows,
                                   column)) {
                        if (grid.get(row).get(col) == 1) {
                            solution.get(row).set(col,
                                                  1);
                            if (safeMove(grid,
                                         row,
                                         col - 1,
                                         rows,
                                         column,
                                         "left")) {
                                if (grid.get(row).get(col - 1) == 0) {
                                    /*grid.get(row).set(col - 1,
                                                      1);*/
                                    solution.get(row).set(col - 1,
                                                          1);
                                }
                            }
                            if (safeMove(grid,
                                         row,
                                         col + 1,
                                         rows,
                                         column,
                                         "right")) {
                                if (grid.get(row).get(col + 1) == 0) {
                                    solution.get(row).set(col + 1,
                                                          1);
                                }
                            }
                            if (safeMove(grid,
                                         row - 1,
                                         col,
                                         rows,
                                         column,
                                         "top")) {
                                if (grid.get(row - 1).get(col) == 0) {
                                    solution.get(row - 1).set(col,
                                                              1);
                                }
                            }
                            if (safeMove(grid,
                                         row + 1,
                                         col,
                                         rows,
                                         column,
                                         "bottom")) {
                                if (grid.get(row + 1).get(col) == 0) {
                                    solution.get(row + 1).set(col,
                                                              1);
                                }
                            }
                        }

                    }
                }
            }
            grid = clone(solution);

        }

        printMatrixAndCheck(solution);
        return result;
    }

    public static <T> List<List<T>> clone (final List<List<T>> solution)
    {
        return solution.stream().map(ArrayList::new)
                        .collect(Collectors.toList());
    }

    private void printMatrixAndCheck (List<List<Integer>> grid)
    {
        for (List<Integer> row : grid) {
            for (Integer col : row) {
                System.out.print(col + " ");
            }
            System.out.println("\n");
        }
    }

    private static boolean safeMove (List<List<Integer>> grid,
                                     int row,
                                     Integer col,
                                     int rows,
                                     int column,
                                     String left)
    {
        if (row < rows && col < column && row >= 0 && col >= 0) {
            return true;
        }

        return false;
    }

    private static boolean safeToMove (List<List<Integer>> grid,
                                       int row,
                                       int col,
                                       int rows,
                                       int column)
    {
        if (grid.get(row).get(col) < gridlength && row < rows && col < column && row >= 0
                        && col >= 0) {
            return true;
        }
        return false;

    }

}
