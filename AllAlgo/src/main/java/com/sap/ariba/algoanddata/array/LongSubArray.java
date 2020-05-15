package com.sap.ariba.algoanddata.array;

import java.util.Arrays;

public class LongSubArray
{

    public static void main (String args[])
    {
        int[] array = { 1, -2, 3, 4, -5, 8 };

        solution(array);
        checkingMaxGobalMax(array);
    }

    private static void solution (int[] array)
    {
        int max = 0;
        int[] solutionArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {

            int sum = 0;
            Arrays.fill(solutionArray,
                        0);
            for (int j = i; j >= 0; j--) {
                sum = sum + array[j];
                solutionArray[j] = array[j];
                if (max < sum) {
                    max = sum;
                    Arrays.stream(solutionArray).forEach(System.out::print);
                    System.out.println(" ");
                }

                // max = Math.max(max,sum);

            }
        }

        System.out.println(String.format("Longest Cong Sum : %s",
                                         max));

    }

    private static void checkingMaxGobalMax (int[] arrya)
    {
        int current_max = 0;
        int gobal_max = 0;

        for (int i = 0; i < arrya.length; i++) {
            current_max = Math.max(arrya[i],
                                   current_max + arrya[i]);

            gobal_max = Math.max(current_max,
                                 gobal_max);
        }

        System.out.println(String.format("Different solution %s", gobal_max));
    }
}
