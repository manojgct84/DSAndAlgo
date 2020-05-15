package com.sap.ariba.algoanddata.Codility;

import java.util.ArrayList;
import java.util.List;

public class TruckPopUp
{

    static List<List<Integer>> mainList = new ArrayList<List<Integer>>();

    public static void main (String args[])
    {
        /*for(int i=0;i<4;i++) {
            ArrayList<Integer> intList = new ArrayList<Integer>();
            for(int k=0;k<4;k++) {
                intList.add(k);
            }
            mainList.add(intList);
        }*/

        mainList.add(new ArrayList<>());
        mainList.get(0).add(1);
        mainList.get(0).add(1);
        mainList.get(0).add(0);
        mainList.get(0).add(0);


        mainList.add(new ArrayList<>());
        mainList.get(1).add(0);
        mainList.get(1).add(1);
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
        mainList.get(3).add(1);
        mainList.get(3).add(1);

        mainList.add(new ArrayList<>());
        mainList.get(4).add(1);
        mainList.get(4).add(1);
        mainList.get(4).add(1);
        mainList.get(4).add(1);

        System.out.println(numberAmazonTreasureTrucks(5,
                                                      4,
                                                      mainList));

    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static int numberAmazonTreasureTrucks (int rows,
                                           int column,
                                           List<List<Integer>> grid)
    {

        if (grid.size() == 0) {
            return 0;
        }
        else if (grid.get(0).size() == 0) {
            return 0;
        }
        int result = 0;
        for (List<Integer> row : grid) {
            int previousColValue = Integer.MAX_VALUE;
            int currentValue = Integer.MAX_VALUE;
            for (Integer col : row) {
                currentValue = col.intValue();
                // System.out.println("CV " + currentValue);
                // System.out.println("PV " + previousColValue);
                if (currentValue == 0 && previousColValue == 1) {
                    result = result + 1;
                }
                previousColValue = currentValue;
            }
            //if the list column has one and previous have 0
            if (currentValue == 1 && previousColValue == 0) {
                result = result + 1;

            }

        }

        return result;

    }

}
