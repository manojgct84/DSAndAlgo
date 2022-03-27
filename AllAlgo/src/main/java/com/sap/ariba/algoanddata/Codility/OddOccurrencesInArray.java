package com.sap.ariba.algoanddata.Codility;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray
{
    public static void main (String args[])
    {
        System.out.println("" + solution(new int[] { 9, 3, 9, 3, 9, 7, 9 }));

    }

    public static int solution (int[] A)
    {
        //Solution 1
        Map<Integer, Integer> pair = new HashMap<>();

        for (int value : A) {

            if (pair.containsKey(value)) {
                pair.put(value, pair.get(value) + 1);
            }
            else {
                pair.put(value, 1);
            }
        }
        //End

        //Solution 3
        int[] index = new int[A.length];
        int j = 0;
        int m = 0;

        //for (int i = 0; i < A.length; i++) {
        int i = 0;
        while (i < A.length) {
            j = i + 1;
            while (j < A.length) {
                if (A[i] == A[j] && index[j] != 1) {
                    index[i] = 1;
                    index[j] = 1;
                    j++;
                }
                else {
                    if (j < A.length - 1 && index[j + 1] == 1) {
                        j = j + 2;
                    }
                    else {
                        j++;
                    }
                }
            }
            m = i;
            while (m < A.length - 1) {
                if (index[m + 1] == 1) {
                    m++;
                }
                else {
                    i = m + 1;
                    break;
                }
            }
            if (m == A.length - 1) {
                break;
            }
        }
 //End
        //Solution -Start  4
        int number = 0;

        for (int y = 0; y < A.length; y++) {
            number ^= A[y];
        }

        System.out.println("^^>>" + number);
        // End
        for (int k = 0; k < index.length; k++) {
            if (index[k] == 0) {
                System.out.println("A[" + k + "]");
                return A[k];
            }
        }
        //Solution 2
        for (int k = 0; k < A.length; k++) {
            for (int z = k + 1; z < A.length; z++) {
                if (A[k] == A[z] && k != z) {
                    A[k] = 1;
                    A[k] = 1;
                    z = A.length;
                }
            }
        }

        for (int y = 0; y < A.length; y++) {
            if (A[i] != 1) {
                return A[i];
            }
        }
        //End
        return pair.entrySet().

                        stream().

                        filter(e -> e.getValue().

                                        equals(1)).

                        map(Map.Entry::getKey).

                        findFirst().

                        orElse(0);
    }
}
