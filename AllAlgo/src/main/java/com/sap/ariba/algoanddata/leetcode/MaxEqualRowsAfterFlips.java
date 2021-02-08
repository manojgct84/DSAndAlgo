package com.sap.ariba.algoanddata.leetcode;

import java.util.HashMap;

public class MaxEqualRowsAfterFlips
{

    public static void main (String args[])
    {
        /*System.out.println(maxEqualRowsAfterFlips(new int[][] { { 0, 1, 0, 1 }, { 1, 0, 1, 0 },
                        { 0, 1, 0, 1 }, { 1, 0, 1, 0 } }));*/
      /*  System.out.println(maxEqualRowsAfterFlips(new int[][] { { 0, 0, 0 }, { 0, 0, 1 },
                        { 1, 1, 0 } }));*/
        System.out.println(maxEqualRowsAfterFlips(new int[][] { { 0, 0, 0, 0 }, { 0, 1, 0, 0 },
                        { 1, 0, 1, 1 } }));
    }

    public static int maxEqualRowsAfterFlips (int[][] matrix)
    {
        HashMap<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][0] == 1) {
                    if (matrix[i][j] == 0) {
                        sb.append(1);
                    }
                    else {
                        sb.append(0);
                    }
                }
                else {
                    sb.append(matrix[i][j]);
                }
            }
            String tmp = sb.toString();
            System.out.println(tmp);
            if (!map.containsKey(tmp)) {
                map.put(tmp, 1);
            }
            else {
                map.put(tmp, map.get(tmp) + 1);
            }
        }
        for (String i : map.keySet()) {
            res = Math.max(res, map.get(i));
        }
        return res;
    }

}
